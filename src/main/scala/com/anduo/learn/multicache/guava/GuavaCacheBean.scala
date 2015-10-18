package com.anduo.learn.multicache.guava

import org.springframework.cache.Cache.ValueWrapper
import org.springframework.cache.support.SimpleValueWrapper

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
 * time   : 下午11:06
 */
class GuavaCacheBean(name: String, cache: com.google.common.cache.Cache[Any, Any], allowNullValues: Boolean)
  extends org.springframework.cache.Cache {

  override def evict(key: scala.Any): Unit = cache.invalidate(key)

  override def getName: String = return this.name

  override def get(key: scala.Any): ValueWrapper = {
    val value: Any = cache.getIfPresent(key)
    return (if (value != null) new SimpleValueWrapper(value) else null)
  }

  override def get[T](key: scala.Any, `type`: Class[T]): T = {
    val value: Any = cache.getIfPresent(key)
    if (value != null) {
      return `type`.cast(value)
    }
    return None.get
  }

  override def clear(): Unit = cache.invalidateAll()

  override def put(key: scala.Any, value: scala.Any): Unit = cache.put(key, value)

  override def getNativeCache: AnyRef = return this.cache

}
