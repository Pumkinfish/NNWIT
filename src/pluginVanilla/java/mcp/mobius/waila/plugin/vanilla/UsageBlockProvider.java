package mcp.mobius.waila.plugin.vanilla;

import java.util.concurrent.ThreadLocalRandom;
import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.ITooltipLine;
import mcp.mobius.waila.api.component.ItemComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum UsageBlockProvider implements IBlockComponentProvider {
    INSTANCE;

    private static final Item[] SMITHING_TEMPLATES = new Item[] {
        Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE,
        Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,
        Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE
    };

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        Block block = accessor.getBlock();
        ItemLike professionItem = getWorkstationProfessionItem(block);

        if (professionItem != null) {
            ITooltipLine line = tooltip.addLine();
            line.with(new ItemComponent(new ItemStack(Items.EMERALD)));
            line.with(new ItemComponent(new ItemStack(professionItem)));
            return;
        }

        ItemLike utilityItem = getUtilityItem(block);
        if (utilityItem != null) {
            ITooltipLine line = tooltip.addLine();
            line.with(new ItemComponent(new ItemStack(utilityItem)));
        }
    }

    private ItemLike getWorkstationProfessionItem(Block block) {
        if (block == Blocks.BARREL) {
            return Items.FISHING_ROD;
        } else if (block == Blocks.BLAST_FURNACE) {
            return Items.IRON_INGOT;
        } else if (block == Blocks.BREWING_STAND) {
            return Items.POTION;
        } else if (block == Blocks.CARTOGRAPHY_TABLE) {
            return Items.FILLED_MAP;
        } else if (block == Blocks.CAULDRON || block == Blocks.WATER_CAULDRON || block == Blocks.LAVA_CAULDRON || block == Blocks.POWDER_SNOW_CAULDRON) {
            return Items.LEATHER_CHESTPLATE;
        } else if (block == Blocks.COMPOSTER) {
            return Items.WHEAT;
        } else if (block == Blocks.FLETCHING_TABLE) {
            return Items.BOW;
        } else if (block == Blocks.GRINDSTONE) {
            return Items.IRON_SWORD;
        } else if (block == Blocks.LECTERN) {
            return Items.ENCHANTED_BOOK;
        } else if (block == Blocks.LOOM) {
            return Items.SHEARS;
        } else if (block == Blocks.SMITHING_TABLE) {
            return getRandomSmithingTemplate();
        } else if (block == Blocks.SMOKER) {
            return Items.COOKED_BEEF;
        } else if (block == Blocks.STONECUTTER) {
            return Items.CHISELED_STONE_BRICKS;
        }
        return null;
    }

    private ItemLike getUtilityItem(Block block) {
        if (block == Blocks.CRAFTING_TABLE) {
            return Items.OAK_PLANKS;
        } else if (block == Blocks.CRAFTER) {
            return Items.REDSTONE;
        } else if (block == Blocks.FURNACE) {
            return Items.COAL;
        } else if (block == Blocks.ENCHANTING_TABLE) {
            return Items.LAPIS_LAZULI;
        } else if (block == Blocks.ANVIL || block == Blocks.CHIPPED_ANVIL || block == Blocks.DAMAGED_ANVIL) {
            return Items.IRON_INGOT;
        } else if (block == Blocks.BEACON) {
            return Items.NETHER_STAR;
        } else if (block == Blocks.RESPAWN_ANCHOR) {
            return Items.GLOWSTONE;
        } else if (block == Blocks.ENDER_CHEST) {
            return Items.ENDER_EYE;
        } else if (block == Blocks.JUKEBOX) {
            return Items.MUSIC_DISC_CAT;
        } else if (block == Blocks.NOTE_BLOCK) {
            return Items.BELL;
        } else if (block == Blocks.LODESTONE) {
            return Items.COMPASS;
        }
        return null;
    }

    private Item getRandomSmithingTemplate() {
        int index = ThreadLocalRandom.current().nextInt(SMITHING_TEMPLATES.length);
        return SMITHING_TEMPLATES[index];
    }
}
