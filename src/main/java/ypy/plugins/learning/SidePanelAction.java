package ypy.plugins.learning;

import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.DirectoryBrowserSupport;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ypy on 2014/6/8.
 */
public class SidePanelAction implements Action {

    private AbstractBuild build;

    public SidePanelAction(AbstractBuild build){
        this.build = build;
    }

    public final AbstractBuild<?, ?> getOwner(){
        return build;
    }

    public java.lang.String getIconFileName(){
        return "graph.gif";
    }

    public java.lang.String getDisplayName(){
        return "PYU_side";
    }

    public java.lang.String getUrlName(){
        return "pyuside";
    }

    public void doDynamic(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
        DirectoryBrowserSupport dbs = new DirectoryBrowserSupport(this, new FilePath(build.getRootDir()), "sideTitle", "graph.gif", true);
        dbs.setIndexFileName("index.html"); // Hudson >= 1.312
        dbs.generateResponse(req, rsp, this);
    }
}
