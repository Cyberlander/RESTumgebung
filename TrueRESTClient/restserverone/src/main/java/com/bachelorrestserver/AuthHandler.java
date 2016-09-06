package com.bachelorrestserver;

import java.util.Base64;

/**
 * Created by Felix on 17.05.2016.
 */
public class AuthHandler
{

    public static  boolean allowAuthentication(String base64UserCredentials)
    {
        String[] parts = base64UserCredentials.split(" ");
        String part1 = parts[0]; //Basic
        String part2 = parts[1]; //base64

        byte[] decoded = Base64.getDecoder().decode(part2);
        //String decoded_string = new String(decoded, StandardCharsets.UTF_8);
        // String[] parts_of_decoded_string = decoded_string.split(":");
        //String username = parts_of_decoded_string[0];
        //String password = parts_of_decoded_string[1];

        return true;
    }
}
