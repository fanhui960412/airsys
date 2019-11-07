# 建立项目数据库的表

# Module  One	权限模块[RBAC设计模式去设计表，非常灵活，扩展性也好]
#airsys_user	
#airsys_role	
#airsys_resource 

# Module  Two	人资模块[其实并没有统一的标准，就是仁者见仁智者见智，根据实际情况设计表]


# Module  Three	 行政模块[考勤管理  车辆管理  办公用品管理 休假管理]

# 模板模块

create table if not exists account(
	id int primary key auto_increment,
	name varchar(50) not null,
	balance date
);