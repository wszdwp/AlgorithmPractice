import com.codingpan.leetcode.util.Utility;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class GsonTest {

    class Product {
        public String company = "";
//        @SerializedName("serializeString")
        public String serialized = "";

//        @SerializedName("serialized")
        public Boolean serializedBool = false;

        @Override
        public String toString() {
            return "Product{" +
                    "company='" + company + '\'' +
                    ", serialized='" + serialized + '\'' +
                    ", serializedBool=" + serializedBool +
                    '}';
        }
    }

    private static List<String> getFieldName(Object myObj) {
        List<String> fieldsNameList = new ArrayList<>();
        java.lang.reflect.Field[] allFields = myObj.getClass().getFields();
        for (java.lang.reflect.Field field : allFields) {
            String fieldName = field.getName();
            fieldsNameList.add(fieldName);

        }
        return fieldsNameList;
    }


    public static void main(String[] args) {
        Gson gson = new Gson();
        GsonTest test = new GsonTest();
        String jsonString = "{\"status\":\"A\",\"company\":\"306\",\"item\":\"AC9091-2K\",\"serialized\":false,\"docid\":\"502\"}\n";

        Product product = gson.fromJson(jsonString, Product.class);
        StdOut.println(product.toString());

        Utility.printList(getFieldName(product));

    }
}
