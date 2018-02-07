// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.codeInsight.template.postfix.settings;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate;
import com.intellij.ui.CheckedTreeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostfixTemplateCheckedTreeNode extends CheckedTreeNode {
  @NotNull
  private final String myLanguageName;
  @NotNull
  private PostfixTemplate myTemplate;

  @Nullable
  private PostfixTemplate myInitialTemplate;
  private final boolean myNew;

  @NotNull
  public PostfixTemplate getTemplate() {
    return myTemplate;
  }

  @NotNull
  public String getLanguageName() {
    return myLanguageName;
  }

  PostfixTemplateCheckedTreeNode(@NotNull PostfixTemplate template, @NotNull String languageName, boolean isNew) {
    super(template.getPresentableName());
    myLanguageName = languageName;
    myTemplate = template;
    myInitialTemplate = template;
    myNew = isNew;
  }

  public void setTemplate(@NotNull PostfixTemplate template) {
    if (myInitialTemplate == null) {
      myInitialTemplate = myTemplate;
    }
    myTemplate = template;
  }

  public boolean isChanged() {
    return myInitialTemplate != null && !myInitialTemplate.equals(myTemplate);
  }

  public boolean isNew() {
    return myNew;
  }

  @Override
  public String toString() {
    return myTemplate.getPresentableName();
  }
}
