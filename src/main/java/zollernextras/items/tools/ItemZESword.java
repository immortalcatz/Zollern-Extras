package zollernextras.items.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import zollernextras.lib.ZollernHelper;

public class ItemZESword extends ItemSword {
	
	public ItemZESword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
	}
	
}