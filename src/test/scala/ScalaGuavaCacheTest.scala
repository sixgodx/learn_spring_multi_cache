import java.util.concurrent.TimeUnit

import com.anduo.learn.multicache.guava.GuavaCacheBean
import com.google.common.cache.{LoadingCache, CacheLoader, CacheBuilder}

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Summary: TODO
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 15/10/18
 * time   : 下午11:33
 */
object ScalaGuavaCacheTest {
  def main(args: Array[String]): Unit = {
    val cache: LoadingCache[Any, Any] = CacheBuilder
      .newBuilder().maximumSize(10).expireAfterWrite(5, TimeUnit.SECONDS)
      .build(new CacheLoader[Any, Any] {
        override def load(key: Any): Any = return "a"
      })

    val a = cache("anc")
    println(a)


    val cacheBean = new GuavaCacheBean("a", cache, true);
    val b = cacheBean.get("aaa");
    println(b)
  }
}
