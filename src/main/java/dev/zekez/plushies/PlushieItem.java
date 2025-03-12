package dev.zekez.plushies;

import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.minecraft.block.Block;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;

public class PlushieItem extends FactoryBlockItem {

    public <T extends Block & PolymerBlock> PlushieItem(Block block, Settings settings) {
        super((T) block, settings);
        PolymerItemUtils.enableStonecutterFix();
    }

    public static final Identifier MINING_SPEED_MODIFIER_ID = Identifier.of(PolyPlushies.MOD_ID, "base_attack_damage");

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.BLOCK_BREAK_SPEED, new EntityAttributeModifier(MINING_SPEED_MODIFIER_ID, -3.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, -2.0, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), AttributeModifierSlot.MAINHAND)
                .build();
    }

}