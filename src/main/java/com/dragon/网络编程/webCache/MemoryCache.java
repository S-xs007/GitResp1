package com.dragon.网络编程.webCache;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 这里可以使用更高级的一些缓存方式，比如LRU，LFU等等，也可以缓存到数据库
 */
public class MemoryCache extends ResponseCache {
    //利用conmap存储用户的请求
    private final Map<URI, SimpleCacheResponse> responses
            = new ConcurrentHashMap<URI, SimpleCacheResponse>();
    private final int maxEntries;

    public MemoryCache() {
        this(100);
    }
    public MemoryCache(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {

        if (responses.size() >= maxEntries) return null;

        CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
        if (control.noStore()) {
            return null;
        } else if (!conn.getHeaderField(0).startsWith("GET ")) {
            // only cache GET
            return null;
        }

        SimpleCacheRequest request = new SimpleCacheRequest();
        SimpleCacheResponse response = new SimpleCacheResponse(request, conn, control);

        responses.put(uri, response);
        return request;
    }

    @Override
    public CacheResponse get(URI uri, String requestMethod,
                             Map<String, List<String>> requestHeaders)
            throws IOException {

        if ("GET".equals(requestMethod)) {
            SimpleCacheResponse response = responses.get(uri);
            // check expiration date
            if (response != null && response.isExpired()) {
                responses.remove(response);
                response = null;
            }
            return response;
        } else {
            return null;
        }
    }
}