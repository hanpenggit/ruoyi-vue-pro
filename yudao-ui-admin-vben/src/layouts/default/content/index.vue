<script lang="ts" setup>
import { useContentViewHeight } from './useContentViewHeight'
import PageLayout from '@/layouts/page/index.vue'
import { useDesign } from '@/hooks/web/useDesign'
import { useRootSetting } from '@/hooks/setting/useRootSetting'
import { useTransitionSetting } from '@/hooks/setting/useTransitionSetting'

defineOptions({ name: 'LayoutContent' })

const { prefixCls } = useDesign('layout-content')
const { getOpenPageLoading } = useTransitionSetting()
const { getLayoutContentMode, getPageLoading } = useRootSetting()

useContentViewHeight()
</script>

<template>
  <div v-loading="getOpenPageLoading && getPageLoading" :class="[prefixCls, getLayoutContentMode]">
    <PageLayout />
  </div>
</template>

<style lang="less">
@prefix-cls: ~'@{namespace}-layout-content';

.@{prefix-cls} {
  position: relative;
  flex: 1 1 auto;
  min-height: 0;

  // begin: 下面这块代码 在我的项目打包后在比较宽的屏幕(2K 31 寸)有显示 bug 有偶发性 清缓存首次进入会出现 , 刷新就没了, 这里为什么要指定宽度 ?
  &.fixed {
    width: 1200px;
    margin: 0 auto;
  }
  // end

  &-loading {
    position: absolute;
    top: 200px;
    z-index: @page-loading-z-index;
  }
}
</style>
