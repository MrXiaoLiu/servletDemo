import Medel.BaseCommonMedel;
import Medel.BaseData;
import Medel.BaseDataList;
import Medel.TextModel;
import Utils.ConstantUtil;
import Utils.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletText", urlPatterns = {
        ConstantUtil.ALL_USER_URL, ConstantUtil.QUERY_USER_URL,
        ConstantUtil.ADD_USER_URL, ConstantUtil.UPDATE_USER_URL,
        ConstantUtil.DELETE_USER_URL})
public class ServletText extends HttpServlet {

    XiaoTaoBusiness xiaoTaoBusiness = new XiaoTaoBusiness();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     *
     * @param request 接受数据
     * @param response 返回数据
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //设置相应内容
//        response.setContentType("text/html");
//        //设置逻辑实现
//        PrintWriter printWriter = response.getWriter();
//
//        printWriter.println("<h3>你在说什么</h3>");

        System.out.println("");
        request.setCharacterEncoding("UTF-8");
        //设置相应内容类型
        response.setContentType("text/json;charset=UTF-8");
        String url = request.getRequestURI();

        if (url.contains(ConstantUtil.ALL_USER_URL)) {
            getAllUser(request, response);
        } else if (url.contains(ConstantUtil.QUERY_USER_URL)) {
            getUser(request, response);
        } else if (url.contains(ConstantUtil.ADD_USER_URL)) {
            addUser(request, response);
        }
        else if (url.contains(ConstantUtil.UPDATE_USER_URL)) {
            updateUser(request, response);
        } else if (url.contains(ConstantUtil.DELETE_USER_URL)) {
            deleteUser(request, response);
        }
    }




    private void getAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        List<TextModel> allUser = xiaoTaoBusiness.getAllUser();

        BaseCommonMedel<BaseDataList> baseCommonMedel = new BaseCommonMedel<>();
        if (allUser != null) {
            baseCommonMedel.setSuccess();
            baseCommonMedel.setData(new BaseDataList(allUser));

        } else {
            baseCommonMedel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(baseCommonMedel));
        printWriter.flush();
        printWriter.close();

    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        String id = request.getParameter("id");
        TextModel user = xiaoTaoBusiness.getUser(id);
        BaseCommonMedel<BaseData> baseCommonMedel = new BaseCommonMedel<>();

        if (baseCommonMedel == null) {
            baseCommonMedel.setFail();
        } else {
            baseCommonMedel.setSuccess();
            baseCommonMedel.setData(new BaseData(user));
        }
        printWriter.println(GsonUtil.bean2Json(baseCommonMedel));
        printWriter.flush();
        printWriter.close();

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("id");
        String age = request.getParameter("age");
        String name = request.getParameter("name");

        BaseCommonMedel baseCommonMedel = new BaseCommonMedel();

        TextModel textModel = new TextModel();
        textModel.setId(Integer.parseInt(id));
        textModel.setAge(Double.parseDouble(age));
        textModel.setName(name);
        if (xiaoTaoBusiness.addUser(textModel)){
            baseCommonMedel.setSuccess();
        }else {
            baseCommonMedel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(baseCommonMedel));
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("name");

        BaseCommonMedel baseCommonMedel = new BaseCommonMedel();

        if (xiaoTaoBusiness.updateUser(id,name)){

            baseCommonMedel.setSuccess();
        }else {
            baseCommonMedel.setFail();

        }

        printWriter.println(GsonUtil.bean2Json(baseCommonMedel));
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();

        String id = request.getParameter("id");

        BaseCommonMedel baseCommonMedel = new BaseCommonMedel();

        if (xiaoTaoBusiness.deleteUser(id)){
            baseCommonMedel.setSuccess();
        }else {
            baseCommonMedel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(baseCommonMedel));

    }

}
