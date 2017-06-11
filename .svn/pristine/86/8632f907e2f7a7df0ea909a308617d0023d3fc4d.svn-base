# 接口规范介绍
本接口规范对各个客户端接口操作、相关参数、响应和错误码进行定义，所有提交及返回接收的变量均使用小写。目前支持REST APP，并提供接口操作请求和响应范例。
如统一的报错返回什么信息：REST错误响应
所有访问当出现错误时，HTTP响应包含以下Header信息：
>Content-Type: application/json

HTTP响应码，3xx, 4xx, or 5xx
HTTP Body包含具体错误描述信息，如下例所示：
>{"error": {"code": "NosuchUser", "message": "User not exist"}}

还有就是什么请求的url，请求头SessionKey，编码之类的统一说明。

<!--# 测试接口
## 测试接口
### 接口说明
### URL
### HTTP请求方式
### 请求Headers
### 请求参数
### 响应Headers
### 响应参数
### 示例-->

# 生产线接口

## 获取产品列表信息接口

### 接口说明
获取产品列表信息

### URL
>localhost:8080/jeesite/a/api/v1/pack/product/list

### HTTP请求方式
GET
### 请求Headers

### 请求参数

### 响应Headers

### 响应参数
|参数名称 |类型 |参数描述 |
|--------|:--:|:------:|
|id |String |id |
|code |String |产品代码 |
|sku |String |产品SKU |
|name |String |产品名称 |
|full_name |String |产品全称 |
|shelf_life |Integer |保质期 |
|pcs_gtin |String |单品GTIN |
|ctn_gtin |String |箱GTIN |
|pcs_per_ctn |Integer |每箱单品数 |
|ctn_per_plt |Integer |每托箱数 |
|spec  |String |规格 |
|type |String |产品类型 |
|unit_name |String |单位名称 |


### 示例
```
[
  {
    "id": "000",
    "isNewRecord": false,
    "code": "HVKER",
    "name": "护肤",
    "spec": "6164克/瓶",
    "shelfLife": 12,
    "pcsPerCtn": 414
  },
  {
    "id": "111",
    "isNewRecord": false,
    "code": "VAEER",
    "name": "爽肤水",
    "spec": "2165克/台",
    "shelfLife": 12,
    "pcsPerCtn": 7536
  },
  {
    "id": "222",
    "isNewRecord": false,
    "code": "BGSAFG",
    "name": "隔离霜",
    "spec": "5235克/个",
    "shelfLife": 12,
    "pcsPerCtn": 343
  },
  {
    "id": "333",
    "isNewRecord": false,
    "code": "TGRAEG",
    "name": "眼膜",
    "spec": "675克/台",
    "shelfLife": 12,
    "pcsPerCtn": 1754
  },
  {
    "id": "444",
    "isNewRecord": false,
    "code": "BVRW",
    "name": "口红护膜",
    "spec": "465克/台",
    "shelfLife": 12,
    "pcsPerCtn": 853
  },
  {
    "id": "555",
    "isNewRecord": false,
    "code": "GQWFGE",
    "name": "沐浴露",
    "spec": "1735克/支",
    "shelfLife": 12,
    "pcsPerCtn": 537
  },
  {
    "id": "666",
    "isNewRecord": false,
    "code": "BSAGBRES",
    "name": "润肤露",
    "spec": "1644克/只",
    "shelfLife": 12,
    "pcsPerCtn": 62461
  },
  {
    "id": "777",
    "isNewRecord": false,
    "code": "BGSBD",
    "name": "磨砂膏",
    "spec": "5235克/台",
    "shelfLife": 12,
    "pcsPerCtn": 6526
  },
  {
    "id": "888",
    "isNewRecord": false,
    "code": "NRTF",
    "name": "露",
    "spec": "235克/个",
    "shelfLife": 12,
    "pcsPerCtn": 651
  },
  {
    "id": "999",
    "isNewRecord": false,
    "code": "BSERBG",
    "name": "美白",
    "spec": "175克/个",
    "shelfLife": 12,
    "pcsPerCtn": 154
  }
]
## 同步生产信息接口

### 接口说明
同步生产信息

### URL
>localhost:8080/jeesite/a/api/v1/pack/codes/upload

### HTTP请求方式
POST

### 请求Headers

### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |单品码 |
|etp_code |String |加密码 |
|ctn_code |String |箱码 |
|plt_code |String |托码 |
|line_code |String |生产线号 |
|batch_code |String |批号 |
|pack_date |DateTime |包装日期 |
|valid_period |DateTime |有效期 |
|print_date |DateTime |打印日期 |
|worker_code |String |工人代码 |
|team_code |String |班组代码 |
|product_id |String |产品id |
|factory_id |String |工厂id |

### 响应headers

### 响应参数

### 示例

# 采集器接口
权限： 采集器

## 登陆接口

### 接口说明
登录

### URL
>localhost:8080/jeesite/a/api/v1/pack/user/login

### HTTP请求方式
POST

### 请求Headers

### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|loginName |String |用户名 |
|password |String |密码 |

### 示例
`
{
	"loginName":"thinkgem",
	"password":"admin"
}


### 响应headers

### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|status |||

### 示例
error/200



## 出库单据下载接口

### 接口说明
出库单据下载

### URL
>localhost:8080/jeesite/a/api/v1/warehouse/out/list

### HTTP请求方式
POST

### 请求Headers
### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|send_id |String |发货id |
|scan_by |String |扫描者 |
|track_flag |Boolean |追溯标志 |
### 示例
`
[
    {
        "sendId": "abcd", 
        "scanBy": "admin"
    }, 
    {
        "sendId": "abcd", 
        "scanBy": "admin"
    }
]


### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id |String |主键 |
|code |String | 单据号码 |
|uploadTime |DateTime |上传时间 |
|scan_by |String |扫描者 |
|billType |Integer |单据类型 |
|billStatus |Integer |单据状态 |
|submitBy |String |提交者 |
|sendId |String |发货方id |
|sendName |String |发货方名称 |
|receiveId |String |收货方id |
|receiveName |String |收货方名称 |
|detail_list |List ||

#### detail_list
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|expectPcsQty |Integer |计划出库单品数 |
|actualPcsQty |Integer |实际出库单品数 |
|headerId |String |Header id |
|productId |String |产品id |
|pCode |String |产品代码 |
|pSku |String |产品SKU |
|pName |String |产品名称 |
|batch_code |String |批号 |

### 示例
`
[
    [
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2018-04-14 13:25:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "aaa", 
            "productId": "000", 
            "pCode": "HVKER", 
            "pSku": "", 
            "pName": "护肤", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2016-04-14 12:35:50", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "ccc", 
            "productId": "222", 
            "pCode": "BGSAFG", 
            "pSku": "", 
            "pName": "隔离霜", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2017-01-14 11:25:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "eee", 
            "productId": "444", 
            "pCode": "BVRW", 
            "pSku": "", 
            "pName": "口红护膜", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2017-12-14 20:25:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "ggg", 
            "productId": "666", 
            "pCode": "BSAGBRES", 
            "pSku": "", 
            "pName": "润肤露", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2017-04-14 10:34:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "iii", 
            "productId": "888", 
            "pCode": "NRTF", 
            "pSku": "", 
            "pName": "露", 
            "batchCode": ""
        }
    ], 
    [
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2018-04-14 13:25:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "aaa", 
            "productId": "000", 
            "pCode": "HVKER", 
            "pSku": "", 
            "pName": "护肤", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2016-04-14 12:35:50", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "ccc", 
            "productId": "222", 
            "pCode": "BGSAFG", 
            "pSku": "", 
            "pName": "隔离霜", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2017-01-14 11:25:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "eee", 
            "productId": "444", 
            "pCode": "BVRW", 
            "pSku": "", 
            "pName": "口红护膜", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2017-12-14 20:25:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "ggg", 
            "productId": "666", 
            "pCode": "BSAGBRES", 
            "pSku": "", 
            "pName": "润肤露", 
            "batchCode": ""
        }, 
        {
            "id": "", 
            "isNewRecord": true, 
            "code": "", 
            "uploadTime": "2017-04-14 10:34:54", 
            "scanBy": "admin", 
            "billType": "", 
            "billStatus": "1", 
            "submitBy": "", 
            "sendId": "abcd", 
            "sendCode": "", 
            "receiveId": "", 
            "receiveName": "", 
            "expectPcsQty": 200, 
            "actualPcsQty": 120, 
            "headerId": "iii", 
            "productId": "888", 
            "pCode": "NRTF", 
            "pSku": "", 
            "pName": "露", 
            "batchCode": ""
        }
    ]
]


## 出库单据扫描上传接口
### 接口说明
上传出库单据
### URL
>localhost:8080/jeesite/a/api/v1/warehouse/out/update

### HTTP请求方式
POST

### 请求Headers
### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id |String |主键 |
|code |String | 单据号码 |
|bill_status |Integer |单据状态 |
|upload_id |String |收货方名称 |
|upload_time |DateTime |上传时间 |
|submit_by |String |提交者 |
|scan_by |String |扫描者 |
|product_id |String |产品id |
|detail_list |List ||

#### detail_list
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id |String |主键 |
|header_id |String | |
|order_code |String | 单据号码 |
|product_id |String |产品id |
|batch_code |String |批号 |
|actual_qty_pcs |Integer |实际出库单品数 |
|data_list |List ||

#### data_list
|参数名称 |类型 |参数描述 |备注|
|-------|:---:|:------:|:---:|
|header_id |String | |
|detail_id |String | |
|ctn_code |String |箱码 |
|product_id |String |产品id |
|batch_code |String |批号 |
|scan_code |String |扫描码 |
|scan_by |String |扫描者 |
|scan_time |DateTime |扫描时间 |
|qty |Integer |数量 |
|is_local_int |Integer |是否本地 |undo |

### 示例
```
[{
    "id": "001",
    "code": "001",
    "bill_type":1,
    "bill_status": 1,
    "send_id":"001",
    "send_name":"wc",
    "receive_id":"001",
    "upload_id": "001",
    "upload_time": "2017-02-23 10:58:10",
    "submit_by": "mjj",
    "scan_by": "wc",
    "detail_list": [
        {
            "id": "001",
            "header_id": "001",
            "order_code": "001",
            "product_id": "001",
            "batch_code": "fdsfse",
            "expect_qty_pcs":643,
            "actual_qty_pcs": 432,
            "data_list": [
                {
                    "header_id": "001",
                    "detail_id": "001",
                    "ctn_code": "gfsgfs",
                    "product_id": "001",
                    "batch_code": "nhds",
                    "scan_code": "001",
                    "scan_by": "mjj",
                    "scan_time": "2017-02-23 10:58:10",
                    "qty": 32,
                    "is_local_int": 1
                }
            ]
        }
    ]
}]
```

### 响应Headers
### 响应参数
### 示例

## 扫描代码接口
### 接口说明
验证二维码是否可以出库

### URL
>localhost:8080/jeesite/a/api/v1/warehouse/out/scan_check

### HTTP请求方式
POST
### 请求Headers
### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |编码 |
|order_id |String |单据id |

### 示例
```
[
    {
        "isNewRecord": true,
        "cDe": "001",
        "orderCode": "001",
        "batchCode": "LFSDFDDS",
        "productId": "001",
        "productName": "云南白药"
    },
    {
        "isNewRecord": true,
        "cDe": "002",
        "orderCode": "002",
        "batchCode": "LFSDFDDS",
        "productId": "002",
        "productName": "三七牙膏"
    }
]
```

### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|ctnCode |String |箱码 |
|batchCode |String |批号 |
|productId |String |产品id |
|productName |String |产品名称 |

### 示例
```
[
  [
    {
      "isNewRecord": true,
      "cDe": "001",
      "orderCode": "001",
      "batchCode": "HTSHTSR",
      "productId": "666",
      "productName": "润肤露"
    }
  ],
  [
    {
      "isNewRecord": true,
      "cDe": "002",
      "orderCode": "002",
      "batchCode": "GRABDB",
      "productId": "333",
      "productName": "眼膜"
    }
  ]
]
```

## 出库单据状态接口
### 接口说明
确定出库单据状态

### URL
>localhost:8080/jeesite/a/api/v1/warehouse/out/scan_status

### HTTP请求方式
POST

### 请求Headers
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |单据号码 |
|scan_by |String |扫描者 |

### 请求参数
### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |错误代码 |
|message |String |错误消息 |

### 示例
>{"error": {"code": "0", "message": "User not exist"}}

<!--## 退货单据下载接口
### 接口说明
退货单据下载列表
### URL
>http://{domain_name}/api/v1/warehouse/return/list
### HTTP请求方式
POST
### 请求Headers
### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|send_id |String |退货id |
|scan_by |String |扫描者 |
|track_flag |Boolean |追溯标志 |

### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id |String |主键 |
|code |String | 单据号码 |
|bill_type |Integer |单据类型 |
|bill_status |Integer |单据状态 |
|send_id |String |退货方id |
|send_name |String |退货方名称 |
|receive_id |String |收货方id |
|upload_id |String |收货方名称 |
|upload_time |DateTime |上传时间 |
|submit_by |String |提交者 |
|scan_by |String |扫描者 |
|detail_list |List ||

#### detail_list
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|header_id |String |Header id |
|product_id |String |产品id |
|product_code |String |产品代码 |
|product_sku |String |产品SKU |
|product_name |String |产品名称 |
|send_id |String |发货方id |
|receive_id |String |收货方id |
|batch_code |String |批号 |
|expect_qty_pcs |Integer |计划出库单品数 |
|actual_qty_pcs |Integer |实际出库单品数 |
### 示例-->

## 退货单据上传接口
### 接口说明
上传退货单据

### URL
>localhost:8080/jeesite/a/api/v1/warehouse/return/update

### HTTP请求方式
POST

### 请求Headers
### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id |String |主键 |
|code |String | 单据号码
|bill_type |Integer |单据类型
|bill_status |Integer |单据状态 |
|send_id |String |退货方id |
|send_name |String |退货方名称 |
|receive_id |String |收货方id |
|upload_id |String |收货方名称 |
|upload_time |DateTime |上传时间 |
|submit_by |String |提交者 |
|scan_by |String |扫描者 |
|detail_list |List ||

#### detail_list
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id |String |主键 |
|header_id |String |Header id |
|product_id |String |产品id |
|batch_code |String |批号 |
|expect_qty_pcs |Integer |计划退货单品数 |
|actual_qty_pcs |Integer |实际退货单品数 |
|data_list |List ||

#### data_list
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |编码 |
|header_id |String |Header id |
|detail_id |String |Detail id |
|ctn_code |String |箱码 |
|product_id |String |产品id |
|batch_code |String |批号 |
|scan_code |String |扫描码 |
|scan_by |String |扫描者 |
|scan_time |DateTime |扫描时间 |
|qty |Integer |数量 |
|code_list |String |编码列表 |
|is_local_int |Integer |是否本地 |

### 示例
```
[{
    "id": "001",
    "code": "001",
    "bill_type":1,
    "bill_status": 1,
    "send_id":"001",
    "send_name":"wc",
    "receive_id":"001",
    "upload_id": "001",
    "upload_time": "2017-02-23 10:58:10",
    "submit_by": "mjj",
    "scan_by": "wc",
    "detail_list": [
        {
            "id": "001",
            "header_id": "001",
            "order_code": "001",
            "product_id": "001",
            "batch_code": "fdsfse",
            "expect_qty_pcs":643,
            "actual_qty_pcs": 432,
            "data_list": [
                {
                    "header_id": "001",
                    "detail_id": "001",
                    "ctn_code": "gfsgfs",
                    "product_id": "001",
                    "batch_code": "nhds",
                    "scan_code": "001",
                    "scan_by": "mjj",
                    "scan_time": "2017-02-23 10:58:10",
                    "qty": 32,
                    "is_local_int": 1
                }
            ]
        }
    ]
}]
```

### 响应Headers
### 响应参数
### 示例

## 退货扫描代码接口
### 接口说明
验证二维码是否可以退货
### URL
>localhost:8080/jeesite/a/api/v1/warehouse/return/scan_check

### HTTP请求方式
POST
### 请求Headers
### 请求参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |编码 |
|order_id |String |单据id |

### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|scan_code |String |扫描编码 |
|ctn_code |String |箱码 |
|batch_code |String |批号 |
|product_id |String |产品id |
|product_name |String |产品名称 |
|qty |String |数量 |

### 示例

### 响应Headers
### 响应参数
### 示例

## 生产数据文件上传接口
### 接口说明
生产数据加载到数据表中
### URL
>localhost:8080/jeesite/a/api/v1/files/upload

### HTTP请求方式
POST
### 请求Headers
### 请求参数

### 响应Headers
### 响应参数

### 示例
```
{
  "code": "1",
  "errorMsg": "文件夹为空",
  "data": ""
}
```

### 响应Headers
### 响应参数
### 示例

## 防窜货查询接口
### 接口说明
根据编码查询窜货信息
### URL
>localhost:8080/jeesite/a/api/v1/files/upload

### HTTP请求方式
GET
### 请求Headers
### 请求参数
code

### 示例
```
b1a34
```

### 响应Headers
### 响应参数

### 示例
```
[
  {
    "id": "",
    "isNewRecord": true,
    "cCode": "b1a34",
    "pCode": "VAEER",
    "pName": "爽肤水",
    "batchCode": "GBSZB",
    "packDate": 1555205154000,
    "orderCode": "GGFSDF",
    "scanBeginTimeDate": 1555205154000,
    "sumbitDate": 1555205154000,
    "sendName": "总仓",
    "receiveName": "孔经理",
    "receivePhone": "18086424617",
    "receiveAddress": "广东省广州市"
  }
]
```

### 响应Headers
### 响应参数
### 示例

## 生产数据SQL上传接口
### 接口说明
执行SQL脚本
### URL
>localhost:8080/jeesite/a/api/v1/pack/codes/sql

### HTTP请求方式
POST
### 请求Headers
### 请求参数

### 响应Headers
### 响应参数

### 示例



<!--## 退货单据状态接口
### 接口说明
确定退货单据状态
### URL
>http://{domain_name}/api/v1/warehouse/return/scan_status
### HTTP请求方式
POST
### 请求Headers
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |单据号码 |
|scan_by |String |扫描者 |

### 请求参数
### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|code |String |错误代码 |
|message |String |错误消息 |

### 示例
>{"error": {"code": "0", "message": "User not exist"}}-->

## 生产任务接口
### 接口说明
查询生产任务
### URL
>localhost:8080/jeesite/a/api/v1/warehouse/return/scan_check

### HTTP请求方式
POST
### 请求Headers
### 请求参数

### 响应Headers
### 响应参数
|参数名称 |类型 |参数描述 |
|-------|:---:|:------:|
|id|String |任务编号 |
|code|String |生产任务代码 |
|factoryId |String |公司编码 |
|linecode |String |生产线号 |
|productcode |String |产品编码 |
|productsku |String |产品sku |
|batchcode |String |产品批号 |
|packDate |DateTime |包装日期 |
|expectPcsQty |int |计划产量 |
|beginTime |DateTime |开始时间 |
|endTime |DateTime |结束时间 |
|validPeriod |DateTime |有效期 |
|status |int |状态 |
|taskType |int |任务类型 |
|rangOne |int |范围1 |
|rangTwo |int |范围2 |
|rangThree |int|范围3 |
|warranty |int |  |
|attr1 |int |  |
|attr2 |int |  |
|attr3 |int |  |
|attr4 |int |  |
|attr5 |int |  |
|inventoryMaterialId |String |库存物料 |
|expectCtnQty |String |计划箱产量 |

### 示例
```
[
  {
    "id": "8625c0879dc840929568ad78be067e58",
    "isNewRecord": false,
    "code": "001",
    "linecode": "001",
    "batchCode": "001",
    "packDate": "2017-03-02 14:14:38",
    "expectqty": "1000",
    "beginTime": "2017-03-02 14:14:33",
    "endTime": "2017-03-02 14:14:31",
    "validperiod": "2017-03-02 14:14:28",
    "status": "0",
    "taskType": "1",
    "warranty": "保证完成",
    "expectctnqty": "1000",
    "pname": "云南白药",
    "sku": "清火消炎"
  }
]
```

### 响应Headers
### 响应参数
### 示例