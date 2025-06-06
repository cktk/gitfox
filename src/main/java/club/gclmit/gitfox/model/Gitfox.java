package club.gclmit.gitfox.model;

import com.alibaba.fastjson.JSONArray;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


/**
 * 插件配置
 *
 * @author <a href="https://blog.gclmit.club">gclm</a>
 * @since 2022/6/29 14:13
 * @since jdk11
 */
public class Gitfox implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String style;
    private String language;

    private  List<CommitGuide> templateList;

    public List<CommitGuide> getTemplateList() {
        String emoji = """
                [
                  {
                    "code": "🎨",
                    "description_en": "Improve structure/format of the code",
                    "description": "改进项目结构/代码格式"
                  },
                  {
                    "code": "⚡️",
                    "description_en": "Improve performance",
                    "description": "优化性能"
                  },
                  {
                    "code": "🔥",
                    "description_en": "Remove code or files",
                    "description": "删除代码或文件"
                  },
                  {
                    "code": "🐛",
                    "description_en": "Fix a bug",
                    "description": "修复 BUG"
                  },
                  {
                    "code": "🚑",
                    "description_en": "Critical hotfix",
                    "description": "紧急热修复"
                  },
                  {
                    "code": "✨",
                    "description_en": "Introduce new features",
                    "description": "引入新特性"
                  },
                  {
                    "code": "📝",
                    "description_en": "Add or update documentation",
                    "description": "添加或更新文件"
                  },
                  {
                    "code": "🚀",
                    "description_en": "Deploy stuff",
                    "description": "部署项目"
                  },
                  {
                    "code": "💄",
                    "description_en": "Add or update the UI and style files",
                    "description": "添加或更新 UI 样式文件"
                  },
                  {
                    "code": "🎉",
                    "description_en": "Begin a project",
                    "description": "初次提交"
                  },
                  {
                    "code": "✅",
                    "description_en": "Add, update, or pass tests",
                    "description": "添加、更新或通过测试"
                  },
                  {
                    "code": "🔒️",
                    "description_en": "Fix security issues",
                    "description": "修复安全问题"
                  },
                  {
                    "code": "🔐",
                    "description_en": "Add or update secrets",
                    "description": "添加或更新 secrets"
                  },
                  {
                    "code": "🔖",
                    "description_en": "Release/Version tags",
                    "description": "Release / Version 标签"
                  },
                  {
                    "code": "🚨",
                    "description_en": "Fix compiler/linter warnings",
                    "description": "修复编译器 / 链接器警告"
                  },
                  {
                    "code": "🚧",
                    "description_en": "Work in progress",
                    "description": "进行中的工作"
                  },
                  {
                    "code": "💚",
                    "description_en": "Fix CI Build",
                    "description": "修复 CI 构建"
                  },
                  {
                    "code": "⬇️",
                    "description_en": "Downgrade dependencies",
                    "description": "降级依赖版本"
                  },
                  {
                    "code": "⬆️",
                    "description_en": "Upgrade dependencies",
                    "description": "升级依赖版本"
                  },
                  {
                    "code": "📌",
                    "description_en": "Pin dependencies to specific versions",
                    "description": "将依赖设定为指定版本"
                  },
                  {
                    "code": "👷",
                    "description_en": "Add or update CI build system",
                    "description": "添加或更新 CI 构建系统"
                  },
                  {
                    "code": "📈",
                    "description_en": "Add or update analytics or track code",
                    "description": "添加或更新分析或跟踪代码"
                  },
                  {
                    "code": "♻️",
                    "description_en": "Refactor code",
                    "description": "重构代码"
                  },
                  {
                    "code": "➕",
                    "description_en": "Add a dependency",
                    "description": "添加依赖"
                  },
                  {
                    "code": "➖",
                    "description_en": "Remove a dependency",
                    "description": "移除依赖"
                  },
                  {
                    "code": "🔧",
                    "description_en": "Add or update configuration files",
                    "description": "添加或更新配置文件"
                  },
                  {
                    "code": "🔨",
                    "description_en": "Add or update development scripts",
                    "description": "添加或更新开发脚本"
                  },
                  {
                    "code": "🌐",
                    "description_en": "Internationalization and localization",
                    "description": "国际化和本地化 i18n"
                  },
                  {
                    "code": "✏️",
                    "description_en": "Fix typos",
                    "description": "修复拼写错误"
                  },
                  {
                    "code": "💩",
                    "description_en": "Write bad code that needs to be improved",
                    "description": "写不好的代码，需要改进"
                  },
                  {
                    "code": "⏪",
                    "description_en": "Revert changes",
                    "description": "还原修改"
                  },
                  {
                    "code": "🔀",
                    "description_en": "Merge branches",
                    "description": "合并分支"
                  },
                  {
                    "code": "📦",
                    "description_en": "Add or update compiled files or packages",
                    "description": "添加或更新已编译的文件或包"
                  },
                  {
                    "code": "👽️",
                    "description_en": "Update code due to external API changes",
                    "description": "由于外部API变化而更新代码"
                  },
                  {
                    "code": "🚚",
                    "description_en": "Move or rename resources (e.g.: files, paths, routes)",
                    "description": "移动或重命名资源"
                  },
                  {
                    "code": "📄",
                    "description_en": "Add or update license",
                    "description": "添加或更新 License"
                  },
                  {
                    "code": "💥",
                    "description_en": "Introduce breaking changes",
                    "description": "引入重大改变"
                  },
                  {
                    "code": "🍱",
                    "description_en": "Add or update assets",
                    "description": "添加或更新资源"
                  },
                  {
                    "code": "♿️",
                    "description_en": "Improve accessibility",
                    "description": "改善无障碍环境"
                  },
                  {
                    "code": "💡",
                    "description_en": "Add or update comments in source code",
                    "description": "在源代码中添加或更新注释"
                  },
                  {
                    "code": "🍻",
                    "description_en": "Write code drunkenly",
                    "description": "醉醺醺的写代码"
                  },
                  {
                    "code": "💬",
                    "description_en": "Add or update text and literals",
                    "description": "添加或更新文本和文字"
                  },
                  {
                    "code": "🗃️",
                    "description_en": "Perform database related changes",
                    "description": "执行与数据库相关的更改"
                  },
                  {
                    "code": "🔊",
                    "description_en": "Add or update logs",
                    "description": "添加或更新日志"
                  },
                  {
                    "code": "🔇",
                    "description_en": "Remove logs",
                    "description": "删除日志"
                  },
                  {
                    "code": "👥",
                    "description_en": "Add or update contributor(s)",
                    "description": "添加或更新贡献者"
                  },
                  {
                    "code": "🚸",
                    "description_en": "Improve user experience/usability",
                    "description": "提高用户体验 / 可用性"
                  },
                  {
                    "code": "🏗️",
                    "description_en": "Make architectural changes",
                    "description": "进行架构更改"
                  },
                  {
                    "code": "📱",
                    "description_en": "Work on responsive design",
                    "description": "响应式设计的工作"
                  },
                  {
                    "code": "🤡",
                    "description_en": "Mock things",
                    "description": "进行 mock 测试"
                  },
                  {
                    "code": "🥚",
                    "description_en": "Add or update an easter egg",
                    "description": "添加或更新一个彩蛋"
                  },
                  {
                    "code": "🙈",
                    "description_en": "Add or update a .gitignore file",
                    "description": "添加或更新 .gitignore 文件"
                  },
                  {
                    "code": "📸",
                    "description_en": "Add or update snapshots",
                    "description": "添加或更新快照"
                  },
                  {
                    "code": "⚗️",
                    "description_en": "Perform experiments",
                    "description": "试验新功能"
                  },
                  {
                    "code": "🔍",
                    "description_en": "Improve SEO",
                    "description": "改善 SEO"
                  },
                  {
                    "code": "🏷️",
                    "description_en": "Add or update types",
                    "description": "添加或更新类型"
                  },
                  {
                    "code": "🌱",
                    "description_en": "Add or update seed files",
                    "description": "添加或更新 SEED 文件"
                  },
                  {
                    "code": "🚩",
                    "description_en": "Add, update, or remove feature flags",
                    "description": "添加、更新或删除特性标志"
                  },
                  {
                    "code": "🥅",
                    "description_en": "Catch errors",
                    "description": "捕获异常"
                  },
                  {
                    "code": "💫",
                    "description_en": "Add or update animations and transitions",
                    "description": "添加或更新动画和过场"
                  },
                  {
                    "code": "🗑️",
                    "description_en": "Deprecate code that needs to be cleaned up",
                    "description": "需要清理的废弃代码"
                  },
                  {
                    "code": "🛂",
                    "description_en": "Work on code related to authorization, roles and permissions",
                    "description": "编写与授权、角色和权限有关的代码"
                  },
                  {
                    "code": "🩹",
                    "description_en": "Simple fix for a non-critical issue",
                    "description": "简单修复非关键性问题"
                  },
                  {
                    "code": "🧐",
                    "description_en": "Data exploration/inspection",
                    "description": "数据探索 / 数据巡检"
                  },
                  {
                    "code": "⚰️",
                    "description_en": "Remove dead code",
                    "description": "删除无效代码"
                  },
                  {
                    "code": "🧪",
                    "description_en": "Add a failing test",
                    "description": "添加一个失败的测试"
                  },
                  {
                    "code": "👔",
                    "description_en": "Add or update business logic",
                    "description": "添加或更新业务逻辑"
                  },
                  {
                    "code": "🩺",
                    "description_en": "Add or update health check",
                    "description": "添加或更新健康检查"
                  },
                  {
                    "code": "🧱",
                    "description_en": "Infrastructure related changes",
                    "description": "与基础设施有关的变化"
                  },
                  {
                    "code": "💻",
                    "description_en": "Improve developer experience",
                    "description": "改善开发者体验"
                  }
                ]
                
                
                """;

        return JSONArray.parseArray(emoji, CommitGuide.class);
    }

    public void setTemplateList(List<CommitGuide> templateList) {
        this.templateList = templateList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gitfox gitfox = (Gitfox)obj;
        return Objects.equals(style, gitfox.style) && Objects.equals(language, gitfox.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(style, language);
    }


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
