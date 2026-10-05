package mcp.mobius.waila.plugin.harvest;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public final class HarvestDropRuleHelper {

    private static final Set<Block> NEVER_DROPS = Collections.newSetFromMap(new IdentityHashMap<>());
    private static final Set<Block> SILK_TOUCH_DROPS = Collections.newSetFromMap(new IdentityHashMap<>());

    static {
        NEVER_DROPS.add(Blocks.BEDROCK);
        NEVER_DROPS.add(Blocks.BARRIER);
        NEVER_DROPS.add(Blocks.SPAWNER);
        NEVER_DROPS.add(Blocks.TRIAL_SPAWNER);
        NEVER_DROPS.add(Blocks.VAULT);
        NEVER_DROPS.add(Blocks.BUDDING_AMETHYST);
        NEVER_DROPS.add(Blocks.REINFORCED_DEEPSLATE);
        NEVER_DROPS.add(Blocks.COMMAND_BLOCK);
        NEVER_DROPS.add(Blocks.CHAIN_COMMAND_BLOCK);
        NEVER_DROPS.add(Blocks.REPEATING_COMMAND_BLOCK);
        NEVER_DROPS.add(Blocks.STRUCTURE_BLOCK);
        NEVER_DROPS.add(Blocks.JIGSAW);
        NEVER_DROPS.add(Blocks.FROGSPAWN);
        NEVER_DROPS.add(Blocks.CHORUS_PLANT);
        NEVER_DROPS.add(Blocks.FARMLAND);
        NEVER_DROPS.add(Blocks.DIRT_PATH);
        NEVER_DROPS.add(Blocks.CAKE);
        NEVER_DROPS.add(Blocks.INFESTED_STONE);
        NEVER_DROPS.add(Blocks.INFESTED_COBBLESTONE);
        NEVER_DROPS.add(Blocks.INFESTED_STONE_BRICKS);
        NEVER_DROPS.add(Blocks.INFESTED_MOSSY_STONE_BRICKS);
        NEVER_DROPS.add(Blocks.INFESTED_CRACKED_STONE_BRICKS);
        NEVER_DROPS.add(Blocks.INFESTED_CHISELED_STONE_BRICKS);
        NEVER_DROPS.add(Blocks.INFESTED_DEEPSLATE);

        SILK_TOUCH_DROPS.add(Blocks.GLASS);
        SILK_TOUCH_DROPS.add(Blocks.GLASS_PANE);
        SILK_TOUCH_DROPS.add(Blocks.TINTED_GLASS);
        SILK_TOUCH_DROPS.add(Blocks.ICE);
        SILK_TOUCH_DROPS.add(Blocks.PACKED_ICE);
        SILK_TOUCH_DROPS.add(Blocks.BLUE_ICE);
        SILK_TOUCH_DROPS.add(Blocks.SEA_LANTERN);
        SILK_TOUCH_DROPS.add(Blocks.GLOWSTONE);
        SILK_TOUCH_DROPS.add(Blocks.BOOKSHELF);
        SILK_TOUCH_DROPS.add(Blocks.ENDER_CHEST);
        SILK_TOUCH_DROPS.add(Blocks.CAMPFIRE);
        SILK_TOUCH_DROPS.add(Blocks.SOUL_CAMPFIRE);
        SILK_TOUCH_DROPS.add(Blocks.BEE_NEST);
        SILK_TOUCH_DROPS.add(Blocks.BEEHIVE);
        SILK_TOUCH_DROPS.add(Blocks.TURTLE_EGG);
        SILK_TOUCH_DROPS.add(Blocks.SNIFFER_EGG);
        SILK_TOUCH_DROPS.add(Blocks.SCULK);
        SILK_TOUCH_DROPS.add(Blocks.SCULK_CATALYST);
        SILK_TOUCH_DROPS.add(Blocks.SCULK_SHRIEKER);
        SILK_TOUCH_DROPS.add(Blocks.SCULK_SENSOR);
        SILK_TOUCH_DROPS.add(Blocks.CALIBRATED_SCULK_SENSOR);
        SILK_TOUCH_DROPS.add(Blocks.MUSHROOM_STEM);
        SILK_TOUCH_DROPS.add(Blocks.BROWN_MUSHROOM_BLOCK);
        SILK_TOUCH_DROPS.add(Blocks.RED_MUSHROOM_BLOCK);
        SILK_TOUCH_DROPS.add(Blocks.MELON);
        SILK_TOUCH_DROPS.add(Blocks.CLAY);
        SILK_TOUCH_DROPS.add(Blocks.GILDED_BLACKSTONE);
    }

    public static boolean neverDrops(BlockState state) {
        return NEVER_DROPS.contains(state.getBlock());
    }

    public static boolean needsSilkTouch(BlockState state) {
        Block block = state.getBlock();
        if (NEVER_DROPS.contains(block)) {
            return false;
        }
        if (SILK_TOUCH_DROPS.contains(block)) {
            return true;
        }
        if (block instanceof StainedGlassBlock || block instanceof StainedGlassPaneBlock || block instanceof LeavesBlock) {
            return true;
        }
        return isSilkTouchOre(block);
    }

    private static boolean isSilkTouchOre(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE ||
               block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE ||
               block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE ||
               block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE ||
               block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE ||
               block == Blocks.NETHER_QUARTZ_ORE || block == Blocks.NETHER_GOLD_ORE;
    }
}
