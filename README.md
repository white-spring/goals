# helix 
螺旋进化app后台


## 创建用户
CREATE USER 'helix'@'%' IDENTIFIED BY "helix";
CREATE USER 'helix'@'localhost' IDENTIFIED BY "helix";
FLUSH PRIVILEGES;



# 创建数据库
CREATE DATABASE helix DEFAULT CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON helix.* TO helix@'%';
GRANT ALL PRIVILEGES ON helix.* TO helix@'localhost';
