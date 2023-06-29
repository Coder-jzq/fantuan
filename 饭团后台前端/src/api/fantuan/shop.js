import request from '@/utils/request'

// 查询店铺管理列表
export function listShop(query) {
  return request({
    url: '/fantuan/shop/list',
    method: 'get',
    params: query
  })
}

// 查询店铺管理详细
export function getShop(id) {
  return request({
    url: '/fantuan/shop/' + id,
    method: 'get'
  })
}

// 新增店铺管理
export function addShop(data) {
  return request({
    url: '/fantuan/shop',
    method: 'post',
    data: data
  })
}

// 修改店铺管理
export function updateShop(data) {
  return request({
    url: '/fantuan/shop',
    method: 'put',
    data: data
  })
}

// 删除店铺管理
export function delShop(id) {
  return request({
    url: '/fantuan/shop/' + id,
    method: 'delete'
  })
}
