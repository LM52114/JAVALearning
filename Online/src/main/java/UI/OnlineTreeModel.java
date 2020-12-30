package Online.src.main.java.UI;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 * @Author Li Hao
 * @Date 2020/10/26 21:28
 * @Version 1.0
 */
public class OnlineTreeModel extends DefaultTreeModel {
    public OnlineTreeModel(TreeNode root) {
        super(root);
    }

    public OnlineTreeModel(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }
}
