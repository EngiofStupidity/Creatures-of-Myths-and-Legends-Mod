package ensil.comal;

import ensil.comal.mixin.NetherPortalAccessor;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.NetherPortal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreaturesOfMythsAndLegendsMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("comal");

	public static final Block DIAMOND_OBSIDIAN = new Block(
			FabricBlockSettings.create()
					.resistance(Blocks.OBSIDIAN.getBlastResistance())
					.hardness(Blocks.OBSIDIAN.getHardness())
					.requiresTool()
	);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Block Registering
		Registry.register(Registries.BLOCK, new Identifier("comal", "diamond_obsidian"), DIAMOND_OBSIDIAN);

		//Item Registering
		Registry.register(Registries.ITEM, new Identifier("comal", "diamond_obsidian"), new BlockItem(DIAMOND_OBSIDIAN, new FabricItemSettings()));

		//Adding to Itemgroups
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.add(DIAMOND_OBSIDIAN);
		});


		LOGGER.info("Hello Fabric world!");
	}
}