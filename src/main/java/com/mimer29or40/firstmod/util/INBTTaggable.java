package com.mimer29or40.firstmod.util;

import net.minecraft.nbt.NBTTagCompound;

public interface INBTTaggable
{
    void readFromNBT(NBTTagCompound nbtTagCompound);

    void writeToNBT(NBTTagCompound nbtTagCompound);
}