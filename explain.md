[TOC]

# All

## "/queryAllBook"

1. 功能：查看所有书籍
2. 访问限制：用于所有访问对象
3. 接口：无
4. 输出：
   1. List< Book >


## "/queryOneBook"

1. 功能：查询书籍
2. 访问限制：用于所有访问对象
3. 接口：
   1. id:int

4. 输出：Book

## "/user/toLogin"

1. 功能：会员登录
2. 访问限制：用于所有访问对象
3. 接口：
   1. number : String
   2. password:String
4. 输出： 
   1. int: 
      1. 如果0代表登陆成功
      2. 如果-1代表登陆失败



## "/user/tologout"

1. 功能：会员退出登录
2. 访问限制：用于所有访问对象
3. 接口：无
4. 输出： String("success")


## "/user/Rigester"

1. 功能：会员注册
2. 访问限制：用于所有访问对象
3. 接口：
   1. name : String
   2. password:String
   3. telephone：String
4. 输出： 
   1. int: 
      1. 如果-1，代表注册失败，可能电话已注册
      2. 该用户的注册id




# Manager

## "/manager/addbook"

1. 功能： 增加书籍
2. 访问限制：仅限于管理员
3. 接口：无
4. 输出：
   1. String("success")


## "/manager/updatebook",
1. 功能：更改书籍信息
2. 访问限制：仅限于管理员
3. 接口：无
4. 输出：
   1. String("success")


## "/manager/subtratebook"
1. 功能：删除书籍
2. 访问限制：仅限于管理员
3. 接口：无
4. 输出：
   1. String("success")


## ”/manager/queryAllcustomer”
1. 功能：查看所有的会员
2. 访问限制：仅限于管理员
3. 接口：无
4. 输出： 
   1. List < customer >


# Customer

## ”/user/queryshoppingcart”
1. 功能：查看购物车
2. 访问限制：仅限于用户
3. 接口：无
4. 输出：
   1. List< Shoppingcartlog >



## ”/user/addshoppingcart”
1. 功能：用户给购物车增添一本书籍
2. 访问限制：仅限于用户
3. 接口：
   1. id：int
4. 输出：无

## ”/user/subtractshoppingcart”

1. 功能：用户给购物车减少一本书籍
2. 访问限制：仅限于用户
3. 接口：
   1. id：int
4. 输出：无

## ”/user/queryAllshoppingorder”

1. 功能：用户查看其所有订单号
2. 访问限制：仅限于用户
3. 接口：无
4. 输出：
   1. List< Integer >



## ”/user/queryOneshoppingorder”

1. 功能：用户查看某一订单
2. 访问限制：仅限于用户
3. 接口：
   1. id:int (订单号)
4. 输出：
   1. List< Shoppingorderlog >


## ”/user/addshoppingorder”

1. 功能：用户将购物车中的书籍变为订单
2. 访问限制：仅限于用户
3. 接口：无
4. 输出：
   1. 如果-1，代表添加失败，该用户购物车为空
   2. 0代表添加订单成功