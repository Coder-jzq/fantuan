import request from '@/utils/request'

// 查询菜品管理列表
export function listGoods(query) {
  return request({
    url: '/fantuan/goods/list',
    method: 'get',
    params: query
  })
}

// 查询菜品管理详细
export function getGoods(id) {
  return request({
    url: '/fantuan/goods/' + id,
    method: 'get'
  })
}

// 新增菜品管理
export function addGoods(data) {
  return request({
    url: '/fantuan/goods',
    method: 'post',
    data: data
  })
}

// 修改菜品管理
export function updateGoods(data) {
  return request({
    url: '/fantuan/goods',
    method: 'put',
    data: data
  })
}

// 删除菜品管理
export function delGoods(id) {
  return request({
    url: '/fantuan/goods/' + id,
    method: 'delete'
  })
}
