package com.thinkgem.jeesite.sierac.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.CodeData;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;
import com.thinkgem.jeesite.sierac.service.CodeDataService;
import com.thinkgem.jeesite.sierac.service.ProductService;
import com.thinkgem.jeesite.sierac.service.RdcOutHeaderService;

@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiSqlController extends BaseController {
    @Autowired
    private CodeDataService codeDataService;

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    @Autowired
    private ProductService productService;

    @SuppressWarnings({})
    @RequestMapping(value = "/pack/codes/sql", method = RequestMethod.POST, headers = { "Accept=application/json" })
    @ResponseBody
    public void upload(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        if (ValidateToken.isToken(request, response)) {
            String rdcOutHeaderId[] = { "aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii", "jjj" };
            String test = "D:\\code.txt";
            String productId[] = { "000", "111", "222", "333", "444", "555", "666", "777", "888", "999" };
            String productCode[] = { "HVKER", "VAEER", "BGSAFG", "TGRAEG", "BVRW", "GQWFGE", "BSAGBRES", "BGSBD",
                    "NRTF", "BSERBG" };
            String productName[] = { "护肤", "爽肤水", "隔离霜", "眼膜", "口红护膜", "沐浴露", "润肤露", "磨砂膏", "露", "美白" };
            String productSpec[] = { "6164克/瓶", "2165克/台", "5235克/个", "675克/台", "465克/台", "1735克/支", "1644克/只",
                    "5235克/台", "235克/个", "175克/个" };
            String codeBatchCode[] = { "BSERV", "GBSZB", "VFAD", "GRABDB", "BFZB", "TRAEG", "HTSHTSR", "TGRAE", "GARE",
                    "BVAFD" };
            String codepackDate[] = { "2018-04-14 13:25:54", "2019-04-14 09:25:54", "2016-04-14 12:35:50",
                    "2017-04-24 09:20:14", "2017-01-14 11:25:54", "2017-04-14 09:27:33", "2017-12-14 20:25:54",
                    "2027-03-14 19:25:54", "2017-04-14 10:34:54", "2017-04-44 19:25:54" };
            String rhscanBeginTimeDate[] = { "2018-04-14 13:25:54", "2019-04-14 09:25:54", "2016-04-14 12:35:50",
                    "2017-04-24 09:20:14", "2017-01-14 11:25:54", "2017-04-14 09:27:33", "2017-12-14 20:25:54",
                    "2027-03-14 19:25:54", "2017-04-14 10:34:54", "2017-04-44 19:25:54" };
            String rhsumbitDate[] = { "2018-04-14 13:25:54", "2019-04-14 09:25:54", "2016-04-14 12:35:50",
                    "2017-04-24 09:20:14", "2017-01-14 11:25:54", "2017-04-14 09:27:33", "2017-12-14 20:25:54",
                    "2027-03-14 19:25:54", "2017-04-14 10:34:54", "2017-04-44 19:25:54" };
            String rhorderCode[] = { "HTRSH", "GGFSDF", "NTTEDRE", "MNDT", "NHGSAR", "NSRTN", "GRAGFG", "BAEFGB",
                    "T4GVFD", "NRTSN" };
            String rhsendName[] = { "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓" };
            String rhreceiveName[] = { "张经理", "孔经理", "王经理", "李经理", "杨经理", "朱经理", "刘经理", "白经理", "关经理", "欧经理" };
            String rhreceivePhone[] = { "13486424617", "18086424617", "19086424637", "18082424617", "15286424617",
                    "19686425317", "18043224617", "18086424663", "18386423617", "15286424625" };
            String rhreceiveAddress[] = { "江苏省常州市", "广东省广州市", "湖北省武汉市", "安徽省合肥市", "北京市", "广州市", "广西壮族自治区", "安徽省合肥市",
                    "桂林", "青岛市" };
            List<String> list = readTxtFileIntoStringArrList(test);
            System.out.println("大小为:" + list.size());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (int i = 0; i < 400; i++) {
                CodeData codeData = new CodeData();
                if (i < 1) {
                    for (int j = 0; j < 10; j++) {
                        RdcOutHeader rdcOutHeader = new RdcOutHeader();
                        Product product = new Product();
                        product.setId(productId[j]);
                        product.setCode(productCode[j]);
                        product.setName(productName[j]);
                        product.setSpec(productSpec[j]);
                        product.setIsNewRecord(true);
                        rdcOutHeader.setId(rdcOutHeaderId[j]);
                        rdcOutHeader.setIsNewRecord(true);
                        rdcOutHeader.setScanBeginTime(sdf.parse(rhscanBeginTimeDate[j]));
                        rdcOutHeader.setSubmitDate(sdf.parse(rhsumbitDate[j]));
                        rdcOutHeader.setOrderCode(rhorderCode[j]);
                        rdcOutHeader.setSendName(rhsendName[j]);
                        rdcOutHeader.setReceiveName(rhreceiveName[j]);
                        rdcOutHeader.setReceivePhone(rhreceivePhone[j]);
                        rdcOutHeader.setReceiveAddress(rhreceiveAddress[j]);
                        productService.save(product);
                        rdcOutHeaderService.save(rdcOutHeader);
                    }
                }
                codeData.setBatchCode(codeBatchCode[i % 10]);
                Date date = sdf.parse(codepackDate[i % 10]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, +24);
                codeData.setValidPeriod(cal.getTime());
                codeData.setPackDate(sdf.parse(codepackDate[i % 10]));
                codeData.setOutHeaderId(rdcOutHeaderId[i % 10]);
                codeData.setProductId(productId[i % 10]);
                codeData.setCode(list.get(i));
                codeDataService.save(codeData);
            }
        }
        response.setStatus(403);
    }

    /**
     * 写文件方法
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!"".equals(lineTxt)) {
                        list.add(lineTxt);
                        System.out.println("每行的内容是这样的:" + lineTxt);
                    }
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println("大小为" + list.size());
        return list;
    }
}
