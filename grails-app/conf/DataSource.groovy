//dataSource {
//    pooled = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
//}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
       /* dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }*/
		
		dataSource {
			pooled = true
			/*url = "jdbc:mysql://172.16.0.106:3306/amib"*/
			/*url = "jdbc:mysql://BIMA-DEVQA-SERV:3306/amibdev"*/
			url = "jdbc:mysql://localhost:3306/consultapfi"
			driverClassName = "com.mysql.jdbc.Driver"
			username = "amib"
			password = "amib"
		}
    }
    test {
       /* dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }*/
    }
    production {
		 dataSource {
			 url = "jdbc:mysql://10.100.128.58:3306/consultapfi"
			 driverClassName = "com.mysql.jdbc.Driver"
			 username = "excel"
			 password = "excel"
			 pooled = true
			 properties {
				 maxActive=120
				 minEvictableIdleTimeMillis=1800000
				 timeBetweenEvictionRunsMillis=1800000
				 numTestsPerEvictionRun=3
				 testOnBorrow=true
				 testWhileIdle=true
				 testOnReturn=true
				 validationQuery="SELECT 1"
			  }
		 }
	 }
}
