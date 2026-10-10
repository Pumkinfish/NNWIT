package mcp.mobius.waila.plugin.harvest;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.InfestedBlock;
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
        Collections.addAll(NEVER_DROPS,
            Blocks.BEDROCK,
            Blocks.BARRIER,
            Blocks.STRUCTURE_VOID,
            Blocks.LIGHT,
            Blocks.COMMAND_BLOCK,
            Blocks.CHAIN_COMMAND_BLOCK,
            Blocks.REPEATING_COMMAND_BLOCK,
            Blocks.STRUCTURE_BLOCK,
            Blocks.JIGSAW
        );

        Collections.addAll(NEVER_DROPS,
            Blocks.SPAWNER,
            Blocks.TRIAL_SPAWNER,
            Blocks.VAULT
        );

        Collections.addAll(NEVER_DROPS,
            Blocks.BUDDING_AMETHYST,
            Blocks.REINFORCED_DEEPSLATE
        );

        Collections.addAll(NEVER_DROPS,
            Blocks.END_PORTAL,
            Blocks.END_PORTAL_FRAME,
            Blocks.END_GATEWAY,
            Blocks.NETHER_PORTAL
        );

        Collections.addAll(NEVER_DROPS,
            Blocks.SUSPICIOUS_SAND,
            Blocks.SUSPICIOUS_GRAVEL
        );

        Collections.addAll(NEVER_DROPS,
            Blocks.FROGSPAWN,
            Blocks.FARMLAND,
            Blocks.DIRT_PATH,
            Blocks.FROSTED_ICE,
            Blocks.FIRE,
            Blocks.SOUL_FIRE,
            Blocks.BUBBLE_COLUMN,
            Blocks.PISTON_HEAD,
            Blocks.MOVING_PISTON
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.GLASS,
            Blocks.GLASS_PANE
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.ICE,
            Blocks.PACKED_ICE,
            Blocks.BLUE_ICE
        );

        SILK_TOUCH_DROPS.add(Blocks.COBWEB);

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.STONE,
            Blocks.DEEPSLATE,
            Blocks.GRASS_BLOCK,
            Blocks.PODZOL,
            Blocks.MYCELIUM,
            Blocks.CRIMSON_NYLIUM,
            Blocks.WARPED_NYLIUM
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.BOOKSHELF,
            Blocks.ENDER_CHEST,
            Blocks.CAMPFIRE,
            Blocks.SOUL_CAMPFIRE,
            Blocks.CLAY,
            Blocks.MELON,
            Blocks.GLOWSTONE,
            Blocks.SEA_LANTERN,
            Blocks.GILDED_BLACKSTONE,
            Blocks.CHORUS_PLANT
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.BEE_NEST,
            Blocks.BEEHIVE,
            Blocks.TURTLE_EGG
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.SCULK,
            Blocks.SCULK_CATALYST,
            Blocks.SCULK_SHRIEKER,
            Blocks.SCULK_SENSOR,
            Blocks.CALIBRATED_SCULK_SENSOR,
            Blocks.SCULK_VEIN
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.SMALL_AMETHYST_BUD,
            Blocks.MEDIUM_AMETHYST_BUD,
            Blocks.LARGE_AMETHYST_BUD,
            Blocks.AMETHYST_CLUSTER
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.MUSHROOM_STEM,
            Blocks.BROWN_MUSHROOM_BLOCK,
            Blocks.RED_MUSHROOM_BLOCK
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.TUBE_CORAL_BLOCK,
            Blocks.BRAIN_CORAL_BLOCK,
            Blocks.BUBBLE_CORAL_BLOCK,
            Blocks.FIRE_CORAL_BLOCK,
            Blocks.HORN_CORAL_BLOCK
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.TUBE_CORAL,
            Blocks.BRAIN_CORAL,
            Blocks.BUBBLE_CORAL,
            Blocks.FIRE_CORAL,
            Blocks.HORN_CORAL
        );

        Collections.addAll(SILK_TOUCH_DROPS,
            Blocks.TUBE_CORAL_FAN,
            Blocks.BRAIN_CORAL_FAN,
            Blocks.BUBBLE_CORAL_FAN,
            Blocks.FIRE_CORAL_FAN,
            Blocks.HORN_CORAL_FAN,
            Blocks.TUBE_CORAL_WALL_FAN,
            Blocks.BRAIN_CORAL_WALL_FAN,
            Blocks.BUBBLE_CORAL_WALL_FAN,
            Blocks.FIRE_CORAL_WALL_FAN,
            Blocks.HORN_CORAL_WALL_FAN
        );
    }

    private HarvestDropRuleHelper() {}

    public static boolean neverDrops(BlockState state) {
        Block block = state.getBlock();
        if (NEVER_DROPS.contains(block)) {
            return true;
        }
        
        return block instanceof CakeBlock 
            || block instanceof CandleCakeBlock 
            || block instanceof InfestedBlock;
    }

    public static boolean needsSilkTouch(BlockState state) {
        if (neverDrops(state)) {
            return false;
        }
        Block block = state.getBlock();
        if (SILK_TOUCH_DROPS.contains(block)) {
            return true;
        }
        if (block instanceof StainedGlassBlock 
            || block instanceof StainedGlassPaneBlock 
            || block instanceof LeavesBlock) {
            return true;
        }
        return isSilkTouchOre(block);
    }

    private static boolean isSilkTouchOre(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE
            || block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE
            || block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE
            || block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE
            || block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE
            || block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE
            || block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE
            || block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE
            || block == Blocks.NETHER_GOLD_ORE || block == Blocks.NETHER_QUARTZ_ORE;
    }
}
