package com.dragon.网络编程.URI;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UTR_Demo {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URI uri = new URI("http://www.cafeaulait.org/books/jnp4/examples/src/URISplitter.java");
        URL url = uri.toURL();
        InputStream inputStream = url.openStream();

        int i = 0;
        while((i = inputStream.read())!=-1){
            System.out.println(i);
        }

    }
}
