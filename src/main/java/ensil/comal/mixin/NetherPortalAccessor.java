package ensil.comal.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.world.dimension.NetherPortal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static ensil.comal.CreaturesOfMythsAndLegendsMod.DIAMOND_OBSIDIAN;

@Mixin(NetherPortal.class)
public class NetherPortalAccessor {
	@Shadow
	private static AbstractBlock.ContextPredicate IS_VALID_FRAME_BLOCK = (state, world, pos) -> {
		return state.isOf(Blocks.OBSIDIAN) || state.isOf(DIAMOND_OBSIDIAN);
	};
}