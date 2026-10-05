package mcp.mobius.waila.plugin.harvest.component;

import mcp.mobius.waila.api.ITooltipComponent;
import mcp.mobius.waila.api.__internal__.ApiSide;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

@ApiSide.ClientOnly
public class SilkTouchComponent implements ITooltipComponent {

    private static final ItemStack STRING_STACK = new ItemStack(Items.STRING);

    @Override
    public int getWidth() {
        return 14;
    }

    @Override
    public int getHeight() {
        return 9;
    }

    @Override
    public void render(GuiGraphicsExtractor ctx, int x, int y, DeltaTracker delta) {
        var pose = ctx.pose();
        pose.pushMatrix();
        pose.translate(x + 3.0F, y - 1.0F);
        pose.scale(0.6F, 0.6F);
        ctx.item(STRING_STACK, 0, 0);
        pose.popMatrix();
    }

}
