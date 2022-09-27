package com.example.login.app.models.security;

public class JwtConfig {

        // #1 openssl genrsa -out jwt.pem
        // #2 openssl rsa -in jwt.pem
        public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" +
                        "MIIEowIBAAKCAQEAsEkUfqRdVRWKPPmUKHvDpWNHW2os1jS2dNInia0xnd9N/O/v\r\n" +
                        "ZaDHMuxWYOAdfoRvQ3ap3ELPQKQItCkMo59hlEgsPxEJVVlz5Nnlv6CRETBhx+tN\r\n" +
                        "6W1vOdDwnkEm+TIbbwR9K3jBhx5gB/kwbSEi9kAb3c4xNRiNQ89JKZYGa3kejrPm\r\n" +
                        "zvCpE33p/DIIXED1VVWCVSMM/8efBUyGPX/wF2l+Ijswlv8lxuMdhIeEuo8zPDQe\r\n" +
                        "NTO5ZVIFLyWIzkPsX+S/6SHwiXvNn1Aj3XFyMxDDK2rZHjwDT3VM2OANgieEaG0b\r\n" +
                        "xZq9CLsRJhDEmFvn5RXRIFmu3L5xIAqLANlNowIDAQABAoIBAHAqz+OU6d4Nipwp\r\n" +
                        "od/wgBhoBytfb5AMklvarFWp4fw17gWXFZhwqM76Giwh7iJmWfVvN71ytTTIKtGX\r\n" +
                        "nPcvnoMfOSgXyvyHonpnOwynOibZxh3S1wxEGZWMIM5RXl8JRvNow8w5VcqHxUrN\r\n" +
                        "f8awYvKU8CY94ImMSbZv2nmfgA45P7EtKPDy9Eu3x+EmrOsB6QqNG5DPOF5fRiD2\r\n" +
                        "g1oUmPOSMVGvMNHAD8l/jJxWEEOK7tdNH3p7Id2XJo4XjJSyOh/RiSexXTAsl609\r\n" +
                        "3kQZi4/Ct6cYgXsSwowJCOFnRORaw8CRJAd1eFQYhlYANRIgfmj7OITiaemmGSnp\r\n" +
                        "fAilQAECgYEA5wQOtvwXPhUjRqW/ns2CjGwbZjjXtYTGkdj4aGQQ+bPo/ICoOfMi\r\n" +
                        "evIkYNkVz/Scm89rflZicP12ORzTHoVzY2CERvy57Kbx5wnNHcNn1jbTA+vvyQ5u\r\n" +
                        "8gPhcgJ6daMwUneAXSuqc5LzjNTT4eo76u2D5IdLfK26HCkqEVIIiAECgYEAw1m/\r\n" +
                        "kmeJ5ZZIpAUAmwD2bCyYsBmTdN1awLQF5xXEyvjVnPzYz5b26Jrxh/jzwL8zFh88\r\n" +
                        "JSPg5gdL+D2mptB4oXFxdZnOzXuvi+kkKmiR5i/FYBsDeEHFkWN5NKAHNYZq4SFY\r\n" +
                        "LMgxjx3pVzEaPf2tjV+6YkVylvyzbQ3YaK1CtaMCgYEAs/FNJOsnj4wXdigVIjUh\r\n" +
                        "ww9SKEWOgC10HpbKp0WKk3W3vTbZ0om4Cdwiye1OODVo51Shfj77XtePBt2U9Okt\r\n" +
                        "//JmFoU0rUk8k6Hmy5AxiYIay6szk4BSmuC68ntLt+Xs9c9vhSNGGdAVNVVx1T8G\r\n" +
                        "fO+VFKTt/6eyl8zYn7UuQAECgYB/zCTxqF6kHc7jzon43YZYekxhWDoJSA5o5ty9\r\n" +
                        "spYNmwBUNW25UK+yuDquk4UTYYIQRNraCUDF+5wNiHePxe5E36w0HS0XbIUJaLpK\r\n" +
                        "LCLWjgX3u3Rnpc+UL5lJfi95KridE21VzpntYMoYSn06dMynIisSwxAWCrdu7pHW\r\n" +
                        "2RI9NQKBgAzUzImoEcrPlPKSPnLhPtHMmytwdmG3VOCb0y7LIu83/zr+af6cl+lE\r\n" +
                        "MyEI1Awu0WsqIX+mPnza3hQTJjWSLxyIroS4BYmKlXOR/4Tw2ey5eFi+J5C2rsbb\r\n" +
                        "ZIqOJXWRm7ZQev7A4ylmlXOPojZgtiYMdHFC7/4/T8kjh3TIhQ+K\r\n" +
                        "-----END RSA PRIVATE KEY-----\r\n";

        // #3 openssl rsa -in jwt.pem -pubout
        public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" +
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsEkUfqRdVRWKPPmUKHvD\r\n" +
                        "pWNHW2os1jS2dNInia0xnd9N/O/vZaDHMuxWYOAdfoRvQ3ap3ELPQKQItCkMo59h\r\n" +
                        "lEgsPxEJVVlz5Nnlv6CRETBhx+tN6W1vOdDwnkEm+TIbbwR9K3jBhx5gB/kwbSEi\r\n" +
                        "9kAb3c4xNRiNQ89JKZYGa3kejrPmzvCpE33p/DIIXED1VVWCVSMM/8efBUyGPX/w\r\n" +
                        "F2l+Ijswlv8lxuMdhIeEuo8zPDQeNTO5ZVIFLyWIzkPsX+S/6SHwiXvNn1Aj3XFy\r\n" +
                        "MxDDK2rZHjwDT3VM2OANgieEaG0bxZq9CLsRJhDEmFvn5RXRIFmu3L5xIAqLANlN\r\n" +
                        "owIDAQAB\r\n" +
                        "-----END PUBLIC KEY-----";
}
