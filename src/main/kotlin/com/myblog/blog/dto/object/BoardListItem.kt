package com.myblog.blog.dto.`object`

data class BoardListItem (
            var boardNumber: Int,
            var title: String,
            var content: String,
            var boardTitleImage: String,
            var favoriteCount: Int,
            var commnetCount: Int,
            var viewCount: Int,
            var writerDatetime: String,
            var writerNickname: String,
            var writerProfileImage: String,
)