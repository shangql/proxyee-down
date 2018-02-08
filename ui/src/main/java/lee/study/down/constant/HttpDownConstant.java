package lee.study.down.constant;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.io.File;
import javax.net.ssl.SSLException;
import lee.study.down.dispatch.HttpDownCallback;
import lee.study.down.dispatch.HttpDownHandleCallback;
import lee.study.down.util.PathUtil;

public class HttpDownConstant {

  public final static String HOME_PATH = PathUtil.ROOT_PATH;
  public final static String MAIN_PATH = new File(HOME_PATH).getParent() + File.separator + "main";
  public final static String TASK_RECORD_PATH = HOME_PATH + ".records.inf";
  public final static String CONFIG_PATH = HOME_PATH + ".config.inf";

  public static SslContext clientSslContext;
  public static NioEventLoopGroup clientLoopGroup;
  public static HttpDownCallback httpDownCallback;

  static {
    try {
      clientSslContext = SslContextBuilder.forClient()
          .trustManager(InsecureTrustManagerFactory.INSTANCE)
          .build();
    } catch (SSLException e) {
      e.printStackTrace();
    }
    clientLoopGroup = new NioEventLoopGroup(1);
    httpDownCallback = new HttpDownHandleCallback();
  }
}