package lagaffe.mc.usefullflesh.mixin;

import com.google.common.collect.ImmutableSet;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(net.minecraft.village.VillagerProfession.class)
public class FarmerMixin {
    @ModifyArgs(method = "<clinit>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/village/VillagerProfession;register(Ljava/lang/String;Lnet/minecraft/registry/RegistryKey;Lcom/google/common/collect/ImmutableSet;Lcom/google/common/collect/ImmutableSet;Lnet/minecraft/sound/SoundEvent;)Lnet/minecraft/village/VillagerProfession;"))
    private static void ModifyFarmerGatherables(Args args)
    {
        if(!args.get(0).equals("farmer"))
            return;

        ImmutableSet<Item> defItemSet = args.get(2);
        ImmutableSet<Item> newSet = ImmutableSet.<Item>builder().addAll(defItemSet).add(Items.ROTTEN_FLESH).build();

        args.set(2, newSet);
    }
}