package mcp.mobius.waila.plugin.harvest;

import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public enum ToolBreakBlockProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        Player player = accessor.getPlayer();
        if (player == null) {
            return;
        }

        ItemStack held = player.getMainHandItem();
        if (held.isEmpty() || !held.isDamageableItem()) {
            return;
        }

        BlockState state = accessor.getBlockState();
        float destroySpeed = state.getDestroySpeed(accessor.getWorld(), accessor.getPosition());
        if (destroySpeed <= 0.0F) {
            return;
        }

        int remainingDurability = held.getMaxDamage() - held.getDamageValue();
        if (remainingDurability <= 1) {
            tooltip.addLine(
                Component.literal("⛏ ⚠ Will Break!").withStyle(ChatFormatting.RED)
            );
        }
    }
}
