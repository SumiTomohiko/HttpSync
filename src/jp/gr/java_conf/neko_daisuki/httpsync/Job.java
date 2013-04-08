package jp.gr.java_conf.neko_daisuki.httpsync;

import java.io.Serializable;

public class Job implements Serializable {

    public long id = -1;
    public String url = "http://";
    public String directory = "/";
    public boolean overwrite = false;

    public String toString() {
        String fmt = "Job: id=%d, url=%s, directory=%s, overwrite=%s";
        String overwrite = Boolean.toString(this.overwrite);
        return String.format(fmt, id, url, directory, overwrite);
    }
}

/**
 * vim: tabstop=4 shiftwidth=4 expandtab softtabstop=4
 */
