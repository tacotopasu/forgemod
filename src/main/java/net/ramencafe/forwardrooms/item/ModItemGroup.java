package net.ramencafe.forwardrooms.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.ramencafe.forwardrooms.ForwardRooms;

public class ModItemGroup {

    // Creating ForwardRooms Tab
    public static final ItemGroup FORWARDROOMS_GROUP = new ItemGroup("ForwardRoomsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ALMOND_WATER.get());
        }
    };

}
