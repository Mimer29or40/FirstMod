package com.mimer29or40.firstmod.util;

public class Setting
{
    public static class I
    {
        private String name;
        private String label;
        private String category;
        private int    value;
        private int    defult;
        private int    min;
        private int    max;

        public I(String category, String name, String label, int defult, int min, int max)
        {
            this.name = name;
            this.label = label;
            this.category = category;
            this.defult = defult;
            this.min = min;
            this.max = max;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        public int getDefult()
        {
            return defult;
        }

        public int getMin()
        {
            return min;
        }

        public int getMax()
        {
            return max;
        }

        public String getName()
        {
            return name;
        }

        public String getLabel()
        {
            return label;
        }

        public String getCategory()
        {
            return category;
        }
    }

    public static class F
    {
        private String name;
        private String label;
        private String category;
        private float  value;
        private float  defult;
        private float  min;
        private float  max;

        public F(String category, String name, String label, float defult, float min, float max)
        {
            this.name = name;
            this.label = label;
            this.category = category;
            this.defult = defult;
            this.min = min;
            this.max = max;
        }

        public float getValue()
        {
            return value;
        }

        public void setValue(float value)
        {
            this.value = value;
        }

        public float getDefult()
        {
            return defult;
        }

        public float getMin()
        {
            return min;
        }

        public float getMax()
        {
            return max;
        }

        public String getName()
        {
            return name;
        }

        public String getLabel()
        {
            return label;
        }

        public String getCategory()
        {
            return category;
        }
    }

    public static class S
    {
        private String name;
        private String label;
        private String category;
        private String value;
        private String defult;

        public S(String category, String name, String label, String defult)
        {
            this.name = name;
            this.label = label;
            this.category = category;
            this.defult = defult;
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        public String getDefult()
        {
            return defult;
        }

        public String getName()
        {
            return name;
        }

        public String getLabel()
        {
            return label;
        }

        public String getCategory()
        {
            return category;
        }
    }

    public static class B
    {
        private String  name;
        private String  label;
        private String  category;
        private boolean value;
        private boolean defult;

        public B(String category, String name, String label, boolean defult)
        {
            this.name = name;
            this.label = label;
            this.category = category;
            this.defult = defult;
        }

        public boolean getValue()
        {
            return value;
        }

        public void setValue(boolean value)
        {
            this.value = value;
        }

        public boolean getDefult()
        {
            return defult;
        }

        public String getName()
        {
            return name;
        }

        public String getLabel()
        {
            return label;
        }

        public String getCategory()
        {
            return category;
        }
    }
}