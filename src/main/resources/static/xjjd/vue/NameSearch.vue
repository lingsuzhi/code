<template>
    <el-col :span="24" style="padding-bottom: 0px;">
        <el-form :inline="true" v-model="filters">
            <el-col :span="20">
                【paramSearch】
                <el-form-item>
                    <el-button type="primary" @click="search" icon="el-icon-search">查询</el-button>
                </el-form-item>
            </el-col>
            <el-col :span="4" align="right">
                <el-form-item>
                    <el-button type="warning" @click="add" icon="el-icon-plus">添加</el-button>
                    <el-button type="danger" @click="killSelection" icon="el-icon-delete">删除</el-button>
                </el-form-item>
            </el-col>
        </el-form>
    </el-col>
</template>

<script>
    export default {
        name: "lsz-pagination",
        props: ['search', 'filters', 'add', 'killSelection'],
        methods: {}
    }
</script>

