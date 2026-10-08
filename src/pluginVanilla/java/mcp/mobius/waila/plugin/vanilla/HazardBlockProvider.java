package mcp.mobius.waila.plugin.vanilla;

import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.ITooltipLine;
import mcp.mobius.waila.api.component.ItemComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum HazardBlockProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        Block block = accessor.getBlock();
        ItemLike hazardIcon = getHazardIcon(block);

        if (hazardIcon != null) {
            ITooltipLine line = tooltip.addLine();
            line.with(new ItemComponent(new ItemStack(Items.SKELETON_SKULL)));
            line.with(new ItemComponent(new ItemStack(hazardIcon)));
        }
    }

    private ItemLike getHazardIcon(Block block) {
        if (block == Blocks.WITHER_ROSE) {
            return Items.WITHER_SKELETON_SKULL;
        } else if (block == Blocks.POWDER_SNOW) {
            return Items.SNOWBALL;
        } else if (block == Blocks.MAGMA_BLOCK || block == Blocks.FIRE || block == Blocks.CAMPFIRE) {
            return Items.FIRE_CHARGE;
        } else if (block == Blocks.SOUL_FIRE || block == Blocks.SOUL_CAMPFIRE) {
            return Items.SOUL_SOIL;
        } else if (block == Blocks.LAVA || block == Blocks.LAVA_CAULDRON) {
            return Items.BLAZE_POWDER;
        } else if (block == Blocks.CACTUS || block == Blocks.SWEET_BERRY_BUSH || block == Blocks.POINTED_DRIPSTONE) {
            return Items.ARROW;
        }
        return null;
    }
}
