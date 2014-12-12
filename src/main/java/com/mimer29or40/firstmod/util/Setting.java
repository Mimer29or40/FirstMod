package com.mimer29or40.firstmod.util;

import com.mimer29or40.firstmod.handler.ConfigurationHandler;

public class Setting
{
    public String                           name;
    public String                           label;
    public String                           category;
    public ConfigurationHandler.SettingType type;

    private int     valueI;
    private float   valueF;
    private boolean valueB;
    private String  valueS;

    private int     defaultI;
    private float   defaultF;
    private boolean defaultB;
    private String  defaultS;

    private int   maxI;
    private float maxF;

    private int   minI;
    private float minF;

    public Setting(ConfigurationHandler.SettingType type, String category, String name, String label, Object defult)
    {
        this(type, category, name, label, defult, 0, 0);
    }

    public Setting(ConfigurationHandler.SettingType type, String category, String name, String label, Object defult, Object min, Object max)
    {
        this.category = category;
        this.name = name;
        this.label = label;
        this.type = type;

        switch(this.type)
        {
            case Int:
                this.defaultI = (Integer) defult;
                this.minI = (Integer) min;
                this.maxI = (Integer) max;
                break;
            case Float:
                this.defaultF = (Float) defult;
                this.minF = (Float) min;
                this.maxF = (Float) max;
                break;
            case Boolean:
                this.defaultB = (Boolean) defult;
                break;
            case String:
                this.defaultS = (String) defult;
                break;
            default:
                throw new RuntimeException("Setting type not Recognized!");
        }
    }

    public Object getValue()
    {
        switch(this.type)
        {
            case Int:
                return valueI;
            case Float:
                return valueF;
            case Boolean:
                return valueB;
            case String:
                return valueS;
            default:
                throw new RuntimeException("Setting type not Recognized!");
        }
    }

    public void setValue(Object value)
    {
        switch(this.type)
        {
            case Int:
                this.valueI = (Integer) value;
                break;
            case Float:
                this.valueF = (Float) value;
                break;
            case Boolean:
                this.valueB = (Boolean) value;
                break;
            case String:
                this.valueS = (String) value;
                break;
            default:
                throw new RuntimeException("Setting type not Recognized!");
        }
    }

    public Object getDefault()
    {
        switch(this.type)
        {
            case Int:
                return defaultI;
            case Float:
                return defaultF;
            case Boolean:
                return defaultB;
            case String:
                return defaultS;
            default:
                throw new RuntimeException("Setting type not Recognized!");
        }
    }

    public Object getMin()
    {
        switch(this.type)
        {
            case Int:
                return minI;
            case Float:
                return minF;
            default:
                throw new RuntimeException("Setting type not a number!");
        }
    }

    public Object getMax()
    {
        switch(this.type)
        {
            case Int:
                return maxI;
            case Float:
                return maxF;
            default:
                throw new RuntimeException("Setting type not a number!");
        }
    }

    public class Int
    {
        private String name;
        private String label;
        private String category;
        private int value;
        private int def;
        private int min;
        private int min;
        private ConfigurationHandler.SettingType type = ConfigurationHandler.SettingType.Int;

        public Int(String category, String name, String label, int defult, int min, int max)
        {
            this.name = name;
            this.label = label;
            this.category = category;

        }
    }
}