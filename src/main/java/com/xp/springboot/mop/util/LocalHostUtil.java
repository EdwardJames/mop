package com.xp.springboot.mop.util;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalHostUtil
{
  static final Logger log = LoggerFactory.getLogger(LocalHostUtil.class);

  private static String localHost = null;

  public static void setLocalHost(String host) {
    localHost = host;
  }

  public static String getLocalHost() throws Exception {
    if (StringUtils.isNotBlank(localHost)) {
      return localHost;
    }
    localHost = findLocalHost();
    return localHost;
  }

  private static String findLocalHost() throws SocketException, UnknownHostException
  {
    Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
    InetAddress ipv6Address = null;
    while (enumeration.hasMoreElements()) {
      NetworkInterface networkInterface = (NetworkInterface)enumeration.nextElement();
      Enumeration en = networkInterface.getInetAddresses();
      while (en.hasMoreElements()) {
        InetAddress address = (InetAddress)en.nextElement();
        if (!address.isLoopbackAddress()) {
          if ((address instanceof Inet6Address)) {
            ipv6Address = address;
          }
          else
          {
            return normalizeHostAddress(address);
          }
        }
      }
    }

    if (ipv6Address != null) {
      return normalizeHostAddress(ipv6Address);
    }
    InetAddress localHost = InetAddress.getLocalHost();
    return normalizeHostAddress(localHost);
  }

  public static String normalizeHostAddress(InetAddress localHost)
  {
    if ((localHost instanceof Inet6Address)) {
      return localHost.getHostAddress();
    }

    return localHost.getHostAddress();
  }

  public static String getLastSegment()
  {
    try
    {
      String lastSegIP = getLocalHost();
      return lastSegIP.substring(lastSegIP.lastIndexOf(".") + 1);
    } catch (Exception e) {
    }
    return String.valueOf(System.currentTimeMillis() % 604800000L);
  }
}