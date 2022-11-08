package com.mitahcodegarage.models.datadefinition;

public enum DataType {
    TEXT {
        public String mysqlType() { return "VARCHAR"; }
        public String postgresType() { return "VARCHAR"; }
        public String schemaRegistryType() { return "string"; }
        public String convertStringToDataType(String input) {
            return input;
        }
    },
    NUMERIC { // Whole number
        public String mysqlType() {
            return "INTEGER";
        }
        public String postgresType() { return "INTEGER"; }
        public String schemaRegistryType() { return "int"; }
        public Integer convertStringToDataType(String input) {
            return Integer.parseInt(input);
        }
    },
    DECIMAL { // Decimal
        public String mysqlType() {
            return "DECIMAL";
        }
        public String postgresType() { return "DECIMAL"; }
        public String schemaRegistryType() { return "double"; }
        public Double convertStringToDataType(String input) {
            return Double.parseDouble(input);
        }
    },
    BOOLEAN {
        public String mysqlType() {
            return "BOOLEAN";
        }
        public String postgresType() { return "BOOLEAN"; }
        public String schemaRegistryType() { return "boolean"; }
        public Boolean convertStringToDataType(String input) {
            return Boolean.parseBoolean(input);
        }
    };

    public abstract String mysqlType();
    public abstract String postgresType();
    public abstract String schemaRegistryType();
    public abstract Object convertStringToDataType(String input);
}
