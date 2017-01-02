package apple_shields.packets;

import apple_shields.AppleShields;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShieldDestroyPacketHandler implements IMessageHandler<ShieldDestroyMessage, IMessage>
{
    @Override
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(ShieldDestroyMessage message, MessageContext ctx)
    {
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        
        if (player.getEntityId() == message.entityId)
        {
            player.playSound(AppleShields.soundAppleSplat, 1.8F, 0.8F + (player.worldObj.rand.nextFloat() * 0.4F));
            player.renderBrokenItemStack(player.getActiveItemStack());
            // if(player.getActiveItemStack().getItem() instanceof ItemWhiteAppleShield || player.getActiveItemStack().getItem() instanceof ItemWhiteAppleShieldRF)
            // player.addChatMessage(new TextComponentTranslation("chat.i_shield.expired"));
        }
        
        return null;
    }
}
