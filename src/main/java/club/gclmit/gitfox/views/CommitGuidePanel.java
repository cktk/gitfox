package club.gclmit.gitfox.views;

import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.*;


import club.gclmit.gitfox.config.GitfoxState;
import com.intellij.openapi.project.Project;

import club.gclmit.gitfox.model.CommitGuide;
import club.gclmit.gitfox.model.Gitfox;
import cn.hutool.core.util.StrUtil;

/**
 * @author gclm
 */
public class CommitGuidePanel {

    private JPanel mainPanel;
    private JComboBox<String> commitTemplateList;
    private JTextField gitBranch;
    private JTextField shortDescription;
    private JTextArea longDescription;
    private JCheckBox skipCiCheckBox;
    private JCheckBox showBranchCheckBox;
    private CommitGuide currentMessage;

    public CommitGuidePanel(Project project) {

        Gitfox gitfox=new Gitfox();
        List<CommitGuide> templateList = gitfox.getTemplateList();
        currentMessage = templateList.get(0);
        for (CommitGuide message : templateList) {
            String content = GitfoxState.DEFAULT_LANGUAGE.equals(gitfox.getLanguage()) ? message.getCode() + "("
                + message.getDescriptionEn() + ")" : message.getCode() + "(" + message.getDescription() + ")";
            commitTemplateList.addItem(content);
        }
        gitBranch.setText("");
        commitTemplateList.addItemListener(event -> {
            if (ItemEvent.SELECTED == event.getStateChange()) {
                String content = StrUtil.subBetween(event.getItem().toString(), "(", ")");
                for (CommitGuide message : templateList) {
                    if (content.equals(message.getDescription()) || content.equals(message.getDescriptionEn())) {
                        currentMessage = message;
                        break;
                    }
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getCommitMessage() {
        String branch = gitBranch.getText().trim();
        String commitMessage = String.format(CommitGuide.COMMIT_GUIDE_TEMPLATE, currentMessage.getCode(),
            shortDescription.getText(), longDescription.getText());

        if (StrUtil.isNotBlank(branch) && showBranchCheckBox.isSelected()) {
            commitMessage = String.format(CommitGuide.COMMIT_GUIDE_BRANCH_TEMPLATE, currentMessage.getCode(),
                shortDescription.getText(), longDescription.getText(), branch);
        }
        return skipCiCheckBox.isSelected() ? commitMessage + CommitGuide.CI_TEMPLATE : commitMessage;
    }
}
