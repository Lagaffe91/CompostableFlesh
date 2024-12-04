package lagaffe.mc.usefullflesh;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.item.Items;
import net.minecraft.block.ComposterBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Usefullflesh implements ModInitializer {

    public static final String MOD_ID = "compostableflesh";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(Items.ROTTEN_FLESH.asItem(), 0.65F);

        VillagerInteractionRegistries.registerCompostable(Items.ROTTEN_FLESH);
    }
}
