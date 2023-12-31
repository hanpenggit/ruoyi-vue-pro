package cn.iocoder.yudao.module.trade.service.cart;

import cn.iocoder.yudao.module.trade.controller.app.cart.vo.AppTradeCartAddReqVO;
import cn.iocoder.yudao.module.trade.controller.app.cart.vo.AppTradeCartListRespVO;
import cn.iocoder.yudao.module.trade.controller.app.cart.vo.AppTradeCartResetReqVO;
import cn.iocoder.yudao.module.trade.controller.app.cart.vo.AppTradeCartUpdateReqVO;
import cn.iocoder.yudao.module.trade.dal.dataobject.cart.TradeCartDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 购物车 Service 接口
 *
 * @author 柠檬源码
 */
public interface TradeCartService {

    /**
     * 添加商品到购物车
     *
     * @param userId 用户编号
     * @param addReqVO 添加信息
     * @return 购物项的编号
     */
    Long addCart(Long userId, @Valid AppTradeCartAddReqVO addReqVO);

    /**
     * 更新购物车商品数量
     *
     * @param userId 用户编号
     * @param updateCountReqVO 更新信息
     */
    void updateCart(Long userId, AppTradeCartUpdateReqVO updateCountReqVO);

    /**
     * 重置购物车商品
     *
     * 使用场景：在一个购物车项对应的商品失效（例如说 SPU 被下架），可以重新选择对应的 SKU
     *
     * @param userId 用户编号
     * @param updateReqVO 重置信息
     */
    void resetCart(Long userId, AppTradeCartResetReqVO updateReqVO);

    /**
     * 删除购物车商品
     *
     * @param userId 用户编号
     * @param ids 购物项的编号
     */
    void deleteCart(Long userId, Collection<Long> ids);

    /**
     * 查询用户在购物车中的商品数量
     *
     * @param userId 用户编号
     * @return 商品数量
     */
    Integer getCartCount(Long userId);

    /**
     * 查询用户的购物车列表
     *
     * @param userId 用户编号
     * @return 购物车列表
     */
    AppTradeCartListRespVO getCartList(Long userId);

    /**
     * 查询用户的购物车列表
     *
     * @param userId 用户编号
     * @param ids 购物项的编号
     * @return 购物车列表
     */
    List<TradeCartDO> getCartList(Long userId, Set<Long> ids);

    /**
     * 获得用户的购物车商品 SPU 数量的 Map
     *
     * @param userId 用户编号
     * @return 购物车商品 SPU 数量的 Map
     */
    Map<Long, Integer> getCartCountMap(Long userId);

}
