package projects.devdreamers.nearbymeapp.Model;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Comments {

    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

}