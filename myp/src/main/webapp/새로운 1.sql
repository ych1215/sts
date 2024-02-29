insert id="insertCsInf" parameterType="java.util.List" >
INSERT INTO MN_CS
( IDX , CS_ID , CS_NM , REG_DTM , UPDT_DTM )
<foreach collection="list" item="item" separator=" ,">
VALUES ( MN_CS_SEQ.NEXTVAL , #{item.csId} , #{item.csNm} , SYSDATE , SYSDATE )
</foreach>
</insert>

이 방법이나

<update id="insertCsInf" parameterType="java.util.HashMap">
<foreach collection="list" item="item" open="INSERT ALL" close="" separator=" ,">
INTO MN_CS
(
 IDX , CS_ID , CS_NM , REG_DTM , UPDT_DTM 
 )
 VALUES
 (
   MN_CS_SEQ.NEXTVAL , #{item.csId} , #{item.csNm} , SYSDATE , SYSDATE 
 )

</foreach>
</update>

---------

<update id="update" parameterType="java.util.List">
        <foreach collection="list" item="item">
        UPDATE 
            your_table
        SET
            VALUE_ONE = #{item.valueOne}
            , VALUE_TWO = #{item.valueTwo}
            , VALUE_THREE = #{item.valueThree}
        WHERE
        	USER_ID = #{userId}
        </foreach>
    </update>