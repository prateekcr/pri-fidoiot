package org.fido.iot.sample;

/**
 * Contains the configuration property keys and constants that are used by the sample application
 * specifically.
 */
public class OwnerAppConstants {
  
  // the port at which Owner is listening for TO2
  public static final String TO2_PORT = "owner.to2.port";

  // part of the path of exposed web APIs
  public static final String WEB_PATH = "/fido/100/msg";

  // H2 database configuration keys and constants
  public static final String DB_URL = "owner.database.connection.url";
  public static final String DB_USER = "owner.database.username";
  public static final String DB_PWD = "owner.database.password";
  public static final String DB_PORT = "owner.database.port";
  public static final String H2_DRIVER = "org.h2.Driver";
  
  // tomcat's catalaina.home
  public static final String SERVER_PATH = "catalina.home";

  // the user pin for HSM keystore that contains the owner keys
  public static final String OWNER_KEYSTORE_PWD = "owner.keystore.password";

  // the owner keystore type
  public static final String OWNER_KEYSTORE_TYPE = "PKCS11";
  
  // default TO0 waitseconds
  public static final int TO0_REQUEST_WS = 3600;

  public static final String TO0_SCHEDULING_ENABLED = "owner.to0.scheduling.enabled";

}
