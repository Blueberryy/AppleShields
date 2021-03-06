package apple_shields.items;

import java.util.List;

import apple_shields.AppleShields;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWhiteApple extends ItemFood
{
    public ItemWhiteApple(int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);
        setHasSubtypes(true);
    }
    
    public void register(String unlocalizedName)
    {
        setUnlocalizedName("apple_shields." + unlocalizedName);
        GameRegistry.register(this, new ResourceLocation("apple_shields", unlocalizedName));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModels()
    {
        ModelResourceLocation whiteApple = new ModelResourceLocation("apple_shields:white_apple", "inventory");
        
        ModelLoader.setCustomMeshDefinition(this, (stack) -> whiteApple);
        ModelBakery.registerItemVariants(this, whiteApple);
    }
    
    @Override
    public CreativeTabs getCreativeTab()
    {
        return AppleShields.creativeTab;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return stack.getMetadata() > 0;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> list, boolean advanced)
    {
        if (stack.getMetadata() > 0)
        {
            list.add("RF Version");
        }
        else
        {
            list.add("Non RF Version");
        }
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
        list.add(new ItemStack(item));
        
        if (AppleShields.IS_RF_PRESENT)
        {
            list.add(new ItemStack(item, 1, 1));
        }
    }
}
