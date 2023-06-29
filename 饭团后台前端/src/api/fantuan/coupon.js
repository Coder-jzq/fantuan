import request from '@/utils/request'

// 查询优惠券列表
export function listCoupon(query) {
  return request({
    url: '/fantuan/coupon/list',
    method: 'get',
    params: query
  })
}

// 查询优惠券详细
export function getCoupon(id) {
  return request({
    url: '/fantuan/coupon/' + id,
    method: 'get'
  })
}

// 新增优惠券
export function addCoupon(data) {
  return request({
    url: '/fantuan/coupon',
    method: 'post',
    data: data
  })
}

// 修改优惠券
export function updateCoupon(data) {
  return request({
    url: '/fantuan/coupon',
    method: 'put',
    data: data
  })
}

// 删除优惠券
export function delCoupon(id) {
  return request({
    url: '/fantuan/coupon/' + id,
    method: 'delete'
  })
}
