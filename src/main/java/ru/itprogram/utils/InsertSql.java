package ru.itprogram.utils;

public class InsertSql {
    public static final String INSERT_USER =
            "INSERT INTO public.user (administrator, \"name\", email, phone, \"password\") " +
                    "VALUES (?, ?, ?, ?, ?);";
    public static final String INSERT_PRODUCT =
            "INSERT INTO public.product(brand_id, product_type_id, description,quantity," +
                    " warranty, available, price, promo_cod_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
}
