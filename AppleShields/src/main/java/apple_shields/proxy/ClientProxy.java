package apple_shields.proxy;

import apple_shields.AppleShields;
import apple_shields.render.AppleShieldItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        TileEntityItemStackRenderer.instance = new AppleShieldItemRenderer(TileEntityItemStackRenderer.instance);
        
        AppleShields.ITEM_FOOD_WHITE_APPLE.registerModels();
        AppleShields.ITEM_FOOD_APPLE_PIE.registerModels();
        
        AppleShields.ITEM_SHIELD_RED_APPLE.registerModels();
        AppleShields.ITEM_SHIELD_WHITE_APPLE.registerModels();
        AppleShields.ITEM_SHIELD_APPLE_PIE.registerModels();
        AppleShields.ITEM_SHIELD_GOLD_APPLE.registerModels();
        AppleShields.ITEM_SHIELD_ENCHANTED_GOLD_APPLE.registerModels();
        
        if (AppleShields.IS_RF_PRESENT)
        {
            AppleShields.ITEM_SHIELD_RF_WHITE_APPLE.registerModels();
        }
        
        if(Minecraft.getMinecraft().getSession().getUsername().equals("Darkosto"))
        {
            AppleShields.ITEM_SHIELD_APPLE_PIE.setUnlocalizedName("apple_shields.apple_pie_shield.birthday");
        }
    }
}
